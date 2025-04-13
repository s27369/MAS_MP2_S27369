package root.Inne;

import root.ObjectPlus;
import root.StrukturyOrganizacyjne.Batalion;

public class Pojazd extends ObjectPlus {
    String nazwa;
    Batalion batalion;

    public Pojazd(String nazwa){
        setNazwa(nazwa);
    }

    public Batalion getBatalion() {
        return batalion;
    }

    public void setBatalion(Batalion batalion) {
        if(batalion==null){
            throw new IllegalArgumentException("Batalion nie moze byc null");
        }
        this.batalion = batalion;
        this.batalion.addPojazd(this);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        if(nazwa==null || nazwa.isBlank()){
            throw new IllegalArgumentException("Nazwa nie moze byc null ani blank");
        }
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Pojazd{" +
                "nazwa='" + nazwa + '\'' +
                ", batalion=" + batalion +
                '}';
    }
}
