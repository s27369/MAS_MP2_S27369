package kwalifikowana;

public class Auto {
    private Policja policja;
    private String rejestracja;

    public Auto(String rejestracja) {
        this.rejestracja = rejestracja;
    }

    public String getRejestracja() {
        return rejestracja;
    }

    public void setPolicja(Policja policja) {
        if(this.policja == null) {
            this.policja = policja;
            policja.addAuto(this);
        }
    }

    @Override
    public String toString() {
        return "Auto{" +
                "policja=" + policja +
                ", rejestracja='" + rejestracja + '\'' +
                '}';
    }
}
