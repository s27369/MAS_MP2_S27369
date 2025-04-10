package root;

import root.StrukturyOrganizacyjne.*;

public class Main {
    public static void main(String[] args) {
        Brygada brygada = new Brygada(18, "Stołeczna", "Warszawa");
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
    }
}
