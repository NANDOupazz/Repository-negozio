package Model;

import java.util.ArrayList;

public class Studente {

    public ArrayList<Integer> voti;

    // Costruttore
    public Studente() {
        voti = new ArrayList<>();
        voti.add(4);
        voti.add(6);
        voti.add(7);
        voti.add(4);
        voti.add(6);
    }

    public void aggiungiVoto(int voto) {
        voti.add(voto);
    }


    public double calcolaMedia() {
        if (voti.isEmpty()) {
            return 0.0;
        }
        int somma = 0;
        for (int v : voti) {
            somma += v;
        }
        return (double) somma / voti.size();
    }


    public boolean isPromosso() {
        return calcolaMedia() >= 6.0;
    }


    public ArrayList<Integer> getVoti() {
        return voti;
    }
}
