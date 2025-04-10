package root.StrukturyOrganizacyjne;

import old.Adres;
import old.Osoby.Dowodca;

public class Batalion extends StrukturaOrganizacyjna {
    //każdy batalion ma swoją jednostkę.
    //dowódcą batalionu może zostać tylko pułkownik.
    private Adres adresJednostki;
    private StrukturaOrganizacyjna brygadaMacierzysta;

    public Batalion(int numer, Adres adresJednostki) {
        super(numer);
        setAdresJednostki(adresJednostki);
    }

    public Batalion(int numer, Adres adresJednostki, Brygada brygadaMacierzysta) {
        this(numer, adresJednostki);
        setBrygadaMacierzysta(brygadaMacierzysta);
    }

    public StrukturaOrganizacyjna getBrygadaMacierzysta() {
        return brygadaMacierzysta;
    }

    public void setBrygadaMacierzysta(Brygada brygadaMacierzysta) {
        if(brygadaMacierzysta==null) {
            throw new IllegalArgumentException("brygadaMacierzysta nie może być null");
        }
        System.out.println("W ramach "+brygadaMacierzysta+ " uformowano "+this);
        this.brygadaMacierzysta = brygadaMacierzysta;
        brygadaMacierzysta.addBatalion(this);
    }

    public Adres getAdresJednostki() {
        return adresJednostki;
    }

    public void setAdresJednostki(Adres adresJednostki) {
        if(adresJednostki==null){
            throw new IllegalArgumentException("adresJednostki nie może być null");
        }
        this.adresJednostki = adresJednostki;
    }

    @Override
    public void setDowodca(Dowodca dowodca) {
        if(dowodca==null){
            throw new IllegalArgumentException("dowodca nie moze byc null");
        }
        if(!dowodca.getStopien().toLowerCase().equals("pułkownik")){
            throw new IllegalArgumentException("Dowódcą batalionu może zostać tylko pułkownik");
        }
        System.out.println(dowodca+" obejmuje dowództwo w strukturze organizacyjnej: "+ this);
        this.dowodca = dowodca;
    }

    @Override
    public String toString() {
        return numer + " Batalion"+(brygadaMacierzysta!=null?" "+brygadaMacierzysta:"");
    }
}
