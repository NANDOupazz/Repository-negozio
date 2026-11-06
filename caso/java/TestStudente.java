package java;
import Model.Studente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestStudente {


    @BeforeEach
    void creaStudente() {
        IO.println("Inizio test: 6");
    }

    @Test
    @DisplayName("")
    void testVoto(){
        Studente st = new Studente();
    }


}