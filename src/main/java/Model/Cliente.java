package Model;

public class Cliente {
    private int id;
    private String nome;
    private String cognome;
    private String mail;
    private String citta;
    private double saldo;

    public Cliente (){}


    public Cliente (int id,String nome, String cognome, String mail, String citta, double saldo){
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.citta = citta;
        this.saldo = saldo;
    }

    public Cliente (String nome, String cognome, String mail, String citta, double saldo){
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.citta = citta;
        this.saldo = saldo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
