package org.example;

import Database.DatabaseManagement;

import javax.xml.transform.Result;
import java.sql.*;

public class Main {
    static void main() {
        DatabaseManagement db = new DatabaseManagement();
        Connection conn = db.getConnection("Negozio");
        String query = "Select * from clienti";


        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                IO.print(rs.getString("nome"));
                IO.print(" ");
                IO.println(rs.getString("cognome"));
            }
            if (conn != null) {
                conn.close();
            }
            if (stm != null) {
                stm.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();


        }


    }
}

