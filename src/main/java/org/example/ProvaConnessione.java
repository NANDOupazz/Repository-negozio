package org.example;

import Database.DatabaseManagement;
import Database.DatabaseService;
import Model.Cliente;
import DAO.*;
import Model.*;

import java.sql.SQLException;


public class ProvaConnessione {
    void main(){

        DatabaseManagement db = new DatabaseManagement();
        DatabaseService dbs = new DatabaseService();
        ClienteDAO clienteDAO = new ClienteDAO();
        ProdottoDAO prodottoDAO = new ProdottoDAO();
        OrdineDAO ordineDAO = new OrdineDAO();
//
//        // stampiamo un cliente e prodotto con indirizzo 1
//        Cliente clienteTrovato = clienteDAO.findById(19, conn);
//        Prodotto prodottoTrovato = prodottoDAO.findById(1, conn);
//
//        Cliente a1 = new Cliente("Giacomo","Vannacci","Vannacci@mail.com","Napoli",100.00);
//        clienteDAO.insert(a1);
//
//        try{
//            clienteDAO.aggiornaSaldoCliente(8,200.00);
//        } catch (SQLException e ){
//            e.printStackTrace();
//        }
//
//
//        try{
//            prodottoDAO.aggiornaQuantitaProdotti(prodottoTrovato.getId(), 10);
//        } catch (SQLException e){
//            e.printStackTrace();
//        }


// sia soldi che prodotti, cliente che non ha soldi per un prodotto, prova a comprare piu prodotti del possibile,


        dbs.acquistaProdotti(2,2,2);









    }

}
