package zAtrybutem;

import java.util.ArrayList;
import java.util.List;

public class Firma extends ObjectPlus {
    private String nazwa;
    private List<Umowa> pracownikList = new ArrayList<>();

    public Firma(String coi) {
        nazwa = coi;
    }

    public void addPracownik(Pracownik p){
      new Umowa(this, p);
    }

    public void addUmowa(Umowa umowa) {
        pracownikList.add(umowa);
    }

    //removePracownik -> znajdz pracownika na swojej liście umow i to rozwiaz

    //removeUmowa -> removeFromExtent na umowie
}
