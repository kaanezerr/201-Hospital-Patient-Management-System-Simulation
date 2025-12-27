public class Patient {
    int id;
    String name;
    int severity;
    int age;

    public Patient(int id, String name, int severity, int age) {
        this.id = id;
        this.name = name;
        this.severity = severity;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Severity: " + severity + ", Age: " + age;
    }
}