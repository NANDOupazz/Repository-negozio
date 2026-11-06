package java;
import DAO.*;
import Database.DatabaseManagement;
import Model.Cliente;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteDAOTest {

    ClienteDAO cdao;
    Connection conn;
    DatabaseManagement dbm;


    @BeforeEach
    void setUp(){
        conn = new DatabaseManagement().getConnection("negozio");
        cdao = new ClienteDAO();
    }

    @Test
    void testFind(){
        Cliente a2 = cdao.findById(1, conn);
        Assertions.assertNotNull(a2);

    }

    @AfterEach
    void tearDown() throws SQLException {
        conn.rollback();
        conn.close();
    }


}
