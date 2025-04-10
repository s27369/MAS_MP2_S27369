import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student extends Person {
    private static int minAge = 18; //atr. klasowy
    private final List<Grade> grades = new ArrayList<>(); //atr. powtarzalny
    private final List<Uczelnia> uczelniaList = new ArrayList<>();
    private int id;
    private Address address; //atr. zlozony
    private String drugieImie; //atr. opcjonalny


    public Student(int id, String name, int age, Address address) {
        super(name, age);
        try {
            setId(id);
            setAddress(address);
        } catch (Exception e) {
            e.printStackTrace();
            removeFromExtent();
        }
    }

    public Student(int id, String name, int age, Address address, String drugieImie) {
        super(name, age);
        try {
            setId(id);
            setAddress(address);
            setDrugieImie(drugieImie);
        } catch (Exception e) {
            e.printStackTrace();
            removeFromExtent();
        }
    }

    public static Student wyszukajPoID(int id) {  //metoda klasowa
        return ObjectPlus.getExtentFromClass(Student.class).stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    public static int getMinAge() {
        return minAge;
    }

    public static void setMinAge(int minAge) {
        Student.minAge = minAge;
    }

    public void addUczelnia(Uczelnia ucz) {
        if (!uczelniaList.contains(ucz)) {
            uczelniaList.add(ucz);
            ucz.addStudent(this);
        }
    }

    public void removeUczelnia(Uczelnia ucz) {
        if(uczelniaList.remove(ucz)){
        ucz.removeStudent(this);
        }
    }

    public double getSredniaOcen() {  //atr. pochodny / wyliczany
        //implementacja wyliczania średniej ocen dla studenta
        return 4.12;
    }


    public String getDrugieImie() {
        return drugieImie;
    }

    public void setDrugieImie(String drugieImie) {
        if (drugieImie != null) {
            if (drugieImie.isBlank()) {
                throw new IllegalArgumentException("Drugie imie cannot be blank");
            }
        }
        this.drugieImie = drugieImie;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Grade> getGrades() {
        return Collections.unmodifiableList(grades);
    }

    public void addGrade(Grade grade) {
        if (grade.getValue() < 1 || grade.getValue() > 5) {
            throw new IllegalArgumentException("Grade must be between 2 and 5");
        }
        grades.add(grade);
    }

    public void removeGrade(Grade grade) {
        grades.remove(grade);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<Uczelnia> getUczelniaList() {
        return Collections.unmodifiableList(uczelniaList);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", uczelniaList=" + uczelniaList +
                '}';
    }
}
