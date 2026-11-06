package DAO;
import Database.DatabaseManagement;
import Model.*;

import java.sql.*;
import java.util.ArrayList;

public class OrdineDAO implements BaseDAO<Ordine, Integer> {

    DatabaseManagement db = new DatabaseManagement();
    ClienteDAO cDAO = new ClienteDAO();
    ProdottoDAO pDAO = new ProdottoDAO();


    @Override
    public Ordine findById(Integer id, Connection conn) {
        conn = db.getConnection("negozio");

        String query = "select * from ordini where id_o = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            Ordine o = null;

            while (rs.next()) {
                Cliente c = cDAO.findById(rs.getInt("id_cliente"), conn);
                Prodotto p = pDAO.findById(rs.getInt("id_prodotto"), conn);
                System.out.println(rs.getString("id_o") + ". " +
                        rs.getInt("id_cliente") + ". " +
                        rs.getInt("id_prodotto") + ". " +
                        rs.getInt("quantita") + ". " +
                        rs.getDate("data_ordine"));
                o = new Ordine(id, c, p ,rs.getDate("data_ordine"),rs.getInt("quantita"));
            }
            return o;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public ArrayList<Ordine> findAll() {
        DatabaseManagement db = new DatabaseManagement();
        Connection conn = db.getConnection("negozio");

        String query = "select * from ordini";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("data") + " " +
                        rs.getString("quantita"));
            }
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insert(Ordine ordine, Connection conn) {
        DatabaseManagement db = new DatabaseManagement();
        String query = "insert into ordini ( id_cliente, id_prodotto,data_ordine,quantita) values (?, ?, ?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ordine.getCliente().getId());
            ps.setInt(2, ordine.getProdotto().getId());
            ps.setDate(3, ordine.getData());
            ps.setInt(4, ordine.getQuantita());

            int result = ps.executeUpdate();
            if (result > 0) {
                IO.println("Ordine inserito correttamente. ");
            }
        } catch (SQLException e) {
            IO.println("Qualcosa è andato storto! ");
            e.printStackTrace();
        }
        return 0;
    }
}



