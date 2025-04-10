package zAtrybutem;

import java.util.ArrayList;
import java.util.List;

public class Pracownik extends ObjectPlus {
    private String imie;
    private List<Umowa> firmaList = new ArrayList<>();

    public Pracownik(String number) {
        imie = number;
    }

    public void addFirma(Firma f){
        new Umowa(f, this);
    }

    protected void addUmowa(Umowa umowa) {
        firmaList.add(umowa);
    }


    //analogicznie jak w firmie
}
