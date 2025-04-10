import java.util.ArrayList;
import java.util.List;

public class Uczelnia extends ObjectPlus {
    private final String name;

    private final List<Student> studentList = new ArrayList<>();

    public Uczelnia(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        if (!studentList.contains(student)) {
            studentList.add(student);
            student.addUczelnia(this);
        }
    }

    public void removeStudent(Student student) {
        if (studentList.remove(student)) {
            student.removeUczelnia(this);
        }
    }



    @Override
    public String toString() {
        return "Uczelnia{" +
                "name='" + name + '\'' +
                ", studentList=" + studentList.stream().map(s->s.getId()).toList() +
                '}';
    }
}
