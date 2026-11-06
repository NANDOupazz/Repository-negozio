package Database;

import Model.*;
import DAO.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class DatabaseService {

    DatabaseManagement db = new DatabaseManagement();

    public void acquistaProdotti(int id_c, int id_p, int quantita) {

        if (quantita < 1) {
            IO.println("Valore quantitá non valido");
            return;
        }

        ClienteDAO cd = new ClienteDAO();
        ProdottoDAO pd = new ProdottoDAO();
        OrdineDAO od = new OrdineDAO();
        try (Connection conn = db.getConnection("negozio")) {
            try {
                conn.setAutoCommit(false);
                // ricerca cliente
                Cliente cliente = cd.findById(id_c, conn);
                //ricerca prodotto
                Prodotto prodotto = pd.findById(id_p, conn);

                if (cliente != null && prodotto != null) {
                    if (cliente.getSaldo() < (prodotto.getPrezzo() * quantita)) {
                        throw new SQLException("Saldo insufficiente!");
                    }
                    if (prodotto.getQuantita() < quantita) {
                        throw new SQLException("Prodotti selezionati non disponibili! Sono rimasti: " + prodotto.getQuantita() + " item");
                    }

                    Ordine ordine = new Ordine(cliente, prodotto, Date.valueOf(LocalDate.now()),quantita);

                    //inserimento ordine
                    int resultOrdine = od.insert(ordine, conn);

                    if (resultOrdine > 0) {
                        //viene aggiornato il saldo del cliente e anche la quantita dei prodotti
                        cd.aggiornaSaldoCliente(id_c, (cliente.getSaldo() - prodotto.getPrezzo() * quantita), conn);
                        IO.println("Il cliente: " + cliente.getNome() + " ha ora come saldo: " + cliente.getSaldo());

                        pd.aggiornaQuantitaProdotti(id_p, (prodotto.getQuantita() - quantita), conn);
                        conn.commit();
                    } else {
                        throw new SQLException("Errore durante l'inserimento del cliente e/o prodotto!");
                    }
                } else {
                    throw new SQLException("Errore durante la selezione del cliente e/o prodotto!");
                }
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException er) {
            er.printStackTrace();
        }
    }
}
