package root.Inne;

import root.ObjectPlus;
import root.Osoby.Zolnierz;
import root.ToStringType;

public class KsiazeczkaWojskowa extends ObjectPlus {
    private String numerSeryjny;
    private Zolnierz zolnierz;
    private ToStringType toStringType = ToStringType.SIMPLE;

    public KsiazeczkaWojskowa(String numerSeryjny, Zolnierz zolnierz){
        try{
            if(zolnierz==null){
                throw new IllegalArgumentException("zolnierz nie moze byc null");
            }
            setNumerSeryjny(numerSeryjny);
            this.zolnierz = zolnierz;
        }catch(IllegalArgumentException e){
            e.printStackTrace();
            removeFromExtent();
        }

    }

    @Override
    public void removeFromExtent() {
//        Zolnierz z = this.zolnierz;
//        this.zolnierz = null;
//        z.removeKsiazeczkaWojskowa();//NIE MOZNA BO TO NIE LISTA
        super.removeFromExtent();
    }

    public String getNumerSeryjny() {
        return numerSeryjny;
    }

    private void setNumerSeryjny(String numerSeryjny) {
        if(numerSeryjny==null) throw new IllegalArgumentException("Numer seryjny nie moze byc null");
        this.numerSeryjny = numerSeryjny;
    }

    public Zolnierz getZolnierz() {
        return zolnierz;
    }


    @Override
    public String toString() {
        ToStringType zolTyp = this.zolnierz.changeToStringType(ToStringType.SIMPLE);
        String zolMsg = this.zolnierz.toString();
        this.zolnierz.changeToStringType(zolTyp);
        return "Ksiazeczka Wojskowa nr. "+ this.numerSeryjny + " nal. do "+ zolMsg;
    }
}
