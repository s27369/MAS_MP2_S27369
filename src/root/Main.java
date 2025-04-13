package root;

import root.Inne.Adres;
import root.Inne.Kontrakt;
import root.Osoby.Zolnierz;
import root.StrukturyOrganizacyjne.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println("==========================================ASOCJACJA ZWYKLA (Batalion *-1 Brygada)==========================================");
        Brygada brygada = new Brygada(18, "Stołeczna", "Warszawa");
        /*{
            Batalion b1 = new Batalion(181, new Adres("Wesoła", 1, "Warszawa"));
            Batalion b2 = new Batalion(182, new Adres("Smutna", 2, "Warszawa"));

            brygada.changeToStringType(ToStringType.DETAILED);
            b1.changeToStringType(ToStringType.DETAILED);
            b2.changeToStringType(ToStringType.DETAILED);
            System.out.println(brygada);
            System.out.println(b1);
            System.out.println(b2);

            System.out.println("---dodanie b1 przez brygade---");
            brygada.addBatalion(b1);
            System.out.println(brygada);
            System.out.println(b1);

            System.out.println("---dodanie b2 przez batalion---");
            b2.setBrygadaMacierzysta(brygada);
            System.out.println(brygada);
            System.out.println(b2);

            System.out.println("---usuniecie b2 przez batalion---");
            b2.removeBrygadaMacierzysta();
            System.out.println(brygada);
            System.out.println(b2);

            System.out.println("---usuniecie b1 przez brygade---");
            brygada.removeBatalion(b1);
            System.out.println(brygada);
            System.out.println(b1);

            System.out.println("---usuniecie nieprzypisanego batalionu---");
            brygada.removeBatalion(b1);
            System.out.println(brygada);
            System.out.println(b1);
        }*/
        System.out.println("==========================================KONTRAKT(z atrybutem)==========================================");
        Zolnierz zolnierz1 = new Zolnierz("Jan", "Kowalski", "Szeregowy");
        Zolnierz zolnierz2 = new Zolnierz("Karol", "Nowak", "Szeregowy");

        brygada.addZolnierz(zolnierz1, 3);//z brygady
        zolnierz2.addBrygada(brygada, 2);//z zolnierza


        System.out.println("--------------------PO DODANIU KONTRAKTOW--------------------");
        zolnierz1.changeToStringType();
        zolnierz2.changeToStringType();

        printClassExtent(Kontrakt.class);
        printClassExtent(Zolnierz.class);
        printClassExtent(Brygada.class);

        brygada.changeToStringType();
        System.out.println(brygada);

        brygada.removeZolnierz(zolnierz2);
        zolnierz1.removeBrygada(brygada);

        System.out.println("--------------------PO USUNIECIU KONTRAKTOW--------------------");

        printClassExtent(Kontrakt.class);
        printClassExtent(Zolnierz.class);
        printClassExtent(Brygada.class);
        brygada.changeToStringType();

        System.out.println("=====================================KWALIFIKOWANA===============================================");



//        System.out.println("=====================================KOMPOZYCJA===============================================");



    }


    public static void printClassExtent(Class<?> c){
        StringBuilder msg = new StringBuilder(c.getName()+" extent:[\n");
        List<?> extent = ObjectPlus.getExtentFromClass(c);
        int size = extent.size();
        for (int i = 0; i < size; i++) {
            msg.append(extent.get(i).toString());
            if (i != size - 1) {
                msg.append(",\n");
            } else {
                msg.append("\n]");
            }
        }
        System.out.println(msg.toString());
    }
}
