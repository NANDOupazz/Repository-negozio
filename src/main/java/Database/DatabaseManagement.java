package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DatabaseManagement {
    String url = "jdbc:mysql://localhost:3306/negozio";
    String user = "root";
    String passw = "Nando-Il-Pazzo-Root-20";


    public Connection getConnection(String nomeDataBase) {
        String urlCompleto = url + nomeDataBase;
        try {
            Connection conn = DriverManager.getConnection(url, user, passw);
            IO.println("Connessione al DB " + nomeDataBase + " riuscita! ");
            return conn;
        } catch (SQLException e){
            IO.println("Connessione al databse non riuscita");
            e.printStackTrace();
            return null;
        }
    }

}



