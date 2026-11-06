package DAO;

import Database.DatabaseManagement;
import Model.*;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO implements BaseDAO <Cliente, Integer>{


    DatabaseManagement db = new DatabaseManagement();

    @Override
    public Cliente findById(Integer id, Connection conn) {
        conn = db.getConnection("negozio");

        String query = "select * from clienti where id_c = ?";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("id_c") + ". " +
                        rs.getString("nome") + " " +
                        rs.getString("cognome"));
                return new Cliente(rs.getInt("id_c"), rs.getString("nome"), rs.getString("cognome"),
                        rs.getString("email"), rs.getString("citta"),rs.getDouble("saldo"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Cliente> findAll() {
        Connection conn = db.getConnection("negozio");

        String query = "select * from clienti";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("nome") + " " +
                        rs.getString("cognome"));
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
    public int insert(Cliente cliente, Connection conn) {
        String query = "insert into clienti ( nome, cognome, email, citta, saldo) values (?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCognome());
            ps.setString(3, cliente.getMail());
            ps.setString(4, cliente.getCitta());
            ps.setDouble(5, cliente.getSaldo());

            int result = ps.executeUpdate();
            if (result > 0){
                IO.println("Cliente inserito correttamente. ");
            }
        } catch (SQLException e){
            IO.println("Qualcosa è andato storto! ");
            e.printStackTrace();
        }
        return 0;
    }

    public void aggiornaSaldoCliente(Integer id, Double saldoAggiunto, Connection conn) throws SQLException{
         conn = db.getConnection("negozio");
        String query = "UPDATE clienti SET saldo = saldo + ? WHERE id_c = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setDouble(1,saldoAggiunto);
        ps.setInt(2,id);

        int risultato = ps.executeUpdate();
        if (risultato > 0){
            IO.println("Saldo aggiornato con successo!");
        }
        if (conn != null){
            conn.close();
        }
        if(ps != null){
            ps.close();
        }
    }
}



