public class Person extends ObjectPlus {

    private String name;
    private int age;

    public Person(String name, int age) {
        try {
            setName(name);
            setAge(age);
        } catch (Exception e) {
            e.printStackTrace();
            removeFromExtent();
        }

    }

    public String getName(){
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }
}
