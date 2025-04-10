import kompozycja.File;
import kompozycja.Folder;
import kwalifikowana.Auto;
import kwalifikowana.Policja;
import zAtrybutem.Firma;
import zAtrybutem.Pracownik;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student(1, "Student1", 123, new Address("a", "a", "a"));
       Student s2 = new Student(2, "xczxzcc", 1231, new Address("a", "a", "a"));
       new Student(3, "wqqwqwqw", 1231, new Address("a", "a", "a"));
        Uczelnia u1 = new Uczelnia("PJATK");

      u1.addStudent(s1);
      s2.addUczelnia(u1);

     System.out.println(s1);
     System.out.println(u1);
     System.out.println(s2);



     s1.removeUczelnia(u1);
     u1.removeStudent(s2);

     System.out.println("==========================");

     System.out.println(s1);
     System.out.println(u1);
     System.out.println(s2);


        System.out.println("==========++++++++++================");

        Firma firma =new Firma("COI");
        Pracownik pracownik = new Pracownik("1");
        Pracownik pracownik1 = new Pracownik("2");

        firma.addPracownik(pracownik);
        pracownik1.addFirma(firma);

        System.out.println(firma);
        System.out.println(pracownik);
        System.out.println(pracownik1);


        System.out.println("==========++++++++++================");
        Policja cepik = new Policja();
        Auto a1 = new Auto("1");
        Auto a2 = new Auto("2");

        cepik.addAuto(a1);
        a2.setPolicja(cepik);

        System.out.println(cepik);
        System.out.println(a1);
        System.out.println(a2);

        System.out.println(cepik.findAutoByRejestracja("1"));


        System.out.println("==========++++++++++================");

        Folder f1 = new Folder("folder");
        File p1 = new File("p1", f1);
        File p2 = new File("p2", f1);
        File p3 = new File("p3", f1);
        File p4 = new File("p4", f1);



        System.out.println(f1);
        System.out.println(ObjectPlus.getExtentFromClass(Folder.class));
        System.out.println(ObjectPlus.getExtentFromClass(File.class));

        System.out.println("=========================");

        p1.removeFromExtent();

        System.out.println(f1);
        System.out.println(ObjectPlus.getExtentFromClass(Folder.class));
        System.out.println(ObjectPlus.getExtentFromClass(File.class));

        System.out.println("=========================");
        f1.removeFromExtent();

        System.out.println(f1);
        System.out.println(ObjectPlus.getExtentFromClass(Folder.class));
        System.out.println(ObjectPlus.getExtentFromClass(File.class));



    }
}