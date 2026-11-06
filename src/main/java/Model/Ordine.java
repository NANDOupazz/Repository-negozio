package Model;

import java.sql.Date;

public class Ordine {
    private int id;
    private Cliente cliente;
    private Prodotto prodotto;
    private Date data;
    private int quantita;




    public Ordine(Cliente cliente, Prodotto prodotto, Date data, int quantita) {

        this.cliente = cliente;
        this.prodotto = prodotto;
        this.data = data;
        this.quantita = quantita;
    }

    public Ordine(int id, Cliente cliente, Prodotto prodotto, Date data, int quantita) {
        this.id = id;
        this.cliente = cliente;
        this.prodotto = prodotto;
        this.data = data;
        this.quantita = quantita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}
