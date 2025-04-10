package root.StrukturyOrganizacyjne;

import root.Osoby.Dowodca;
import root.ToStringType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Brygada extends StrukturaOrganizacyjna {
    //brygada ma przypisane miasto którego broni i składa się z <=3 batalionów.

    //asocjacja zwykla: brygada 1-*batalion
    private String typ, miasto;
    private List<Batalion> bataliony = new ArrayList<>();

    public Brygada(int numer, String typ, String miasto) {
        super(numer);
        setTyp(typ);
        setMiasto(miasto);
    }

    public void addBatalion(Batalion batalion){
        if(batalion==null)
            throw new IllegalArgumentException("batalion nie może być null");
        if(this.bataliony.contains(batalion)){
            ToStringType typeBryg = this.getToStringType();
            ToStringType typeBat = batalion.getToStringType();
            this.changeToStringType(ToStringType.SIMPLE);
            batalion.changeToStringType(ToStringType.SIMPLE);
            System.out.println("Brygada "+this+ "ma już przypisany batalion "+batalion);
            this.changeToStringType(typeBryg);
            batalion.changeToStringType(typeBat);
            return ;
        }
        this.bataliony.add(batalion);
        batalion.setBrygadaMacierzysta(this);
    }

    public void removeBatalion(Batalion batalion){
        if(batalion==null)
            throw new IllegalArgumentException("batalion nie może być null");

        ToStringType typeBryg = this.getToStringType();
        ToStringType typeBat = batalion.getToStringType();

        if(this.bataliony.contains(batalion)){

            this.changeToStringType(ToStringType.SIMPLE);
            batalion.changeToStringType(ToStringType.SIMPLE);
            System.out.println("Usuwam batalion "+ batalion+ " z "+this);
            this.changeToStringType(typeBryg);
            batalion.changeToStringType(typeBat);

            this.bataliony.remove(batalion);
            batalion.removeBrygadaMacierzysta();
        }else{
            this.changeToStringType(ToStringType.SIMPLE);
            batalion.changeToStringType(ToStringType.SIMPLE);
            System.out.println("Brygada "+this+" nie ma przypisanego batalionu "+batalion);
            this.changeToStringType(typeBryg);
            batalion.changeToStringType(typeBat);
        }
    }

    public List<Batalion> getBataliony() {
        return Collections.unmodifiableList(bataliony);
    }

    @Override
    public void setDowodca(Dowodca dowodca) {
        if(dowodca==null){
            throw new IllegalArgumentException("dowodca nie moze byc null");
        }
        System.out.println(dowodca+" obejmuje dowództwo w strukturze organizacyjnej: "+ this);
        this.dowodca = dowodca;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        if(miasto==null || miasto.isBlank()){
            throw new IllegalArgumentException("miasto nie może być null ani blank");
        }
        this.miasto = miasto;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        if(typ==null || typ.isBlank()){
            throw new IllegalArgumentException("typ nie może być null ani blank");
        }
        this.typ = typ;
    }


    @Override
    public String toString() {
        if(this.toStringType== ToStringType.SIMPLE){
            return numer + " " + typ + " Brygada " + suffix ;
        }else{

            return "Brygada{" +
                    "numer=" + numer +
                    ", typ='" + typ + '\'' +
                    ", miasto='" + miasto + '\'' +
                    ", bataliony=" + bataliony +
                    ", dowodca=" + dowodca +
                    '}';
        }
    }
}
