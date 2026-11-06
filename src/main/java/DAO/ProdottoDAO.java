package DAO;
import Database.DatabaseManagement;
import Model.*;

import java.sql.*;
import java.util.ArrayList;

public class ProdottoDAO implements BaseDAO<Prodotto, Integer> {

    DatabaseManagement db = new DatabaseManagement();

    @Override
    public Prodotto findById(Integer id, Connection conn) {
        conn = db.getConnection("negozio");

        String query = "select * from prodotti where id_p = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id_p") + ". " +
                        rs.getString("nome") + " " +
                        rs.getString("categoria"));
                return new Prodotto(rs.getInt("id_p"), rs.getString("nome"), rs.getString("categoria"), rs.getDouble("prezzo"), rs.getInt("quantita"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public ArrayList<Prodotto> findAll() {
        Connection conn = db.getConnection("negozio");

        String query = "select * from prodotti";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("nome") + " " +
                        rs.getString("categoria") + " " +
                        rs.getDouble("prezzo"));
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
    public int insert(Prodotto prodotto, Connection conn) {
        String query = "insert into prodotti ( nome, categoria, prezzo) values (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, prodotto.getNome());
            ps.setString(2, prodotto.getCategoria());
            ps.setDouble(3, prodotto.getPrezzo());

            int result = ps.executeUpdate();
            if (result > 0) {
                IO.println("Prodotto inserito correttamente. ");
            }
        } catch (SQLException e) {
            IO.println("Qualcosa è andato storto! ");
            e.printStackTrace();
        }
        return 0;
    }

    public void aggiornaQuantitaProdotti(Integer id, Integer quantitaAggiunta, Connection conn) throws SQLException{
        conn = db.getConnection("negozio");
        String query = "UPDATE prodotti SET quantita = quantita + ? WHERE id_p = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1,quantitaAggiunta);
        ps.setInt(2,id);

        int risultato = ps.executeUpdate();
        if (risultato > 0){
            IO.println("Quantita prodotto modificata correttamente!");
        }
        if (conn != null){
            conn.close();
        }

        if(ps != null){
            ps.close();
        }
    }
}


