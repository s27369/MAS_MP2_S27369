package root.StrukturyOrganizacyjne;

import root.Adres;
import root.Osoby.Dowodca;
import root.ToStringType;

public class Batalion extends StrukturaOrganizacyjna {
    //każdy batalion ma swoją jednostkę.
    //dowódcą batalionu może zostać tylko pułkownik.

    //asocjacja zwykla: brygada 1-*batalion
    private Adres adresJednostki;
    private Brygada brygadaMacierzysta;

    public Batalion(int numer, Adres adresJednostki) {
        super(numer);
        setAdresJednostki(adresJednostki);
    }

    public Batalion(int numer, Adres adresJednostki, Brygada brygadaMacierzysta) {
        this(numer, adresJednostki);
        setBrygadaMacierzysta(brygadaMacierzysta);
    }

    public Brygada getBrygadaMacierzysta() {
        return brygadaMacierzysta;
    }

    public void setBrygadaMacierzysta(Brygada brygadaMacierzysta) {
        if(brygadaMacierzysta==null) {//czy argument to null
            throw new IllegalArgumentException("brygadaMacierzysta nie może być null");
        }
        if(this.brygadaMacierzysta==null) {//czy jest juz przypisana brygada mac.
            System.out.println("Brygada macierzysta dla "+this+" jest już przypisana: "+this.brygadaMacierzysta);
            return ;
        }
        System.out.println("W ramach "+brygadaMacierzysta+ " uformowano "+this);
        this.brygadaMacierzysta = brygadaMacierzysta;
        brygadaMacierzysta.addBatalion(this);
    }

    public void removeBrygadaMacierzysta(){
        if(this.brygadaMacierzysta == null){
            System.out.println("Batalion "+this+" nie ma przypisanej brygady macierzystej");
        }else{
            System.out.println("Usuwam przypisanie "+this+ " do "+this.brygadaMacierzysta);
            this.brygadaMacierzysta=null;
        }
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
        if(this.toStringType==ToStringType.SIMPLE){
            return numer + " Batalion "+this.suffix;
        }else{
            String brygadaMsg;
            if(this.brygadaMacierzysta==null){
                brygadaMsg = "brak";
            }else{
                ToStringType type = this.brygadaMacierzysta.getToStringType();
                this.brygadaMacierzysta.changeToStringType(ToStringType.SIMPLE);
                brygadaMsg = brygadaMacierzysta.toString();
                this.brygadaMacierzysta.changeToStringType(type);
            }

            String msg = "Batalion{" +
                    "adresJednostki=" + adresJednostki +
                    ", brygadaMacierzysta=" + brygadaMsg +
                    ", dowodca=" + dowodca +
                    ", numer=" + numer +
                    '}';
            return msg;
        }
    }

}
