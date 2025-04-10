public class Grade {
    private int value;
    private String subject;

    public Grade(int value, String subject) {
        this.value = value;
        this.subject = subject;
    }

    public int getValue() {
        return value;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "value=" + value +
                ", subject='" + subject + '\'' +
                '}';
    }
}
