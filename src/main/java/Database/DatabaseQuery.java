package Database;

import Model.Cliente;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseQuery {

    DatabaseManagement db = new DatabaseManagement();



//    public void findClienteByNomeECognome(String nome, String cognome) {
//
//        Connection conn = db.getConnection("negozio");
//
//        String query = "select * from clienti where nome = ? and cognome = ?";
//
//        try(PreparedStatement ps = conn.prepareStatement(query)){
//            ps.setString(1, nome);
//            ps.setString(2, cognome);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                System.out.println(rs.getString("id_c") + ". " +
//                        rs.getString("nome") + " " +
//                        rs.getString("cognome") + " " +
//                        rs.getString("citta"));
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }




//    public void acquistaProdotto(int clienteId, int prodottoId){}
//    String query1 = "select * from prodotti where id = " + prodotto.getId();
//
//    try {
//        Connection conn = db.getConnection("negozio");
//        Statement stm = conn.createStatement();
//
//        ResultSet rs = stm.executeQuery(query1);
//
//        double prezzoProdotto = rs.getDouble("prezzo");
//
//        String query2 = "update prodotti set quantita = " + (rs.getInt("quantita") -1);
//
//        Cliente c = findClienteById(cliente.getId());
//
//        String query3 = ""
//
//    } catch (SQLException e)





}
