package root.StrukturyOrganizacyjne;

import old.Osoby.Dowodca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Brygada extends StrukturaOrganizacyjna {
    //brygada ma przypisane miasto którego broni i składa się z <=3 batalionów.
    //dowódcą brygady może zostać tylko generał
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
        this.bataliony.add(batalion);
    }

    public List<Batalion> getBataliony() {
        return Collections.unmodifiableList(bataliony);
    }

    @Override
    public void setDowodca(Dowodca dowodca) {
        if(dowodca==null){
            throw new IllegalArgumentException("dowodca nie moze byc null");
        }
        if(!dowodca.czyGeneral){
            throw new IllegalArgumentException("Dowódcą brygady może zostać tylko generał");
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
        return numer + " " + typ + " Brygada " + suffix ;
    }
}
