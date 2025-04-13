package root.Inne;

import root.ObjectPlus;
import root.StrukturyOrganizacyjne.Batalion;
import root.ToStringType;

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

        if(this.batalion == batalion) return;

        if(this.batalion!=null){
            this.batalion.removePojazd(this.nazwa);
        }

        this.batalion = batalion;

        if(batalion.findPojazdByNazwa(this.nazwa) == null)
            this.batalion.addPojazd(this);

    }

    public void removeBatalion(){
        if(this.batalion==null){
            return;
        }
        Batalion batalion = this.batalion;
        this.batalion=null;
        if(batalion.findPojazdByNazwa(this.nazwa) != null)
            batalion.removePojazd(this.nazwa);
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
        String batMsg;
        if(this.batalion==null){
            batMsg="brak";
        }else{
            ToStringType batType = batalion.changeToStringType(ToStringType.SIMPLE);
            batMsg = this.batalion.toString();
            this.batalion.changeToStringType(batType);
        }

        return "Pojazd{" +
                "nazwa='" + nazwa + '\'' +
                ", batalion=" + batMsg +
                '}';
    }
}
