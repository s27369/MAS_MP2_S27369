package zAtrybutem;

import java.time.LocalDate;

public class Umowa extends ObjectPlus {
    private Firma firma;
    private Pracownik pracownik;
    private LocalDate dataZatrudnienia;

    public Umowa(Firma firma, Pracownik pracownik) {
        this.firma = firma;
        this.pracownik = pracownik;
        dataZatrudnienia = LocalDate.now();

        pracownik.addUmowa(this);
        firma.addUmowa(this);
    }

    @Override
    public void removeFromExtent() {
        //rozłączenie relacji z firmą i pracownikiem oraz
        //Usunięcie się z ich list


        super.removeFromExtent();
    }
}
