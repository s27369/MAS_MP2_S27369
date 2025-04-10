package root.StrukturyOrganizacyjne;

import old.ObjectPlus;
import old.Osoby.Dowodca;

public abstract class StrukturaOrganizacyjna extends ObjectPlus {
    Dowodca dowodca;
    int numer;
    protected static final String suffix = "Obrony Terytorialnej";

    public StrukturaOrganizacyjna(int numer) {
        setNumer(numer);
        addToExtent();
    }

    public StrukturaOrganizacyjna(Dowodca dowodca, int numer) {
        this(numer);
        setDowodca(dowodca);
    }


    public Dowodca getDowodca() {
        return dowodca;
    }

    public void setDowodca(Dowodca dowodca) {
        if(dowodca==null){
            throw new IllegalArgumentException("dowodca nie moze byc null");
        }
        this.dowodca = dowodca;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        if (numer<1){
            throw new IllegalArgumentException("numBrygady musi być większy lub równy 1");
        }
        this.numer = numer;
    }
}
