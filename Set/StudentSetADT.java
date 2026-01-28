import java.util.HashSet;

public class StudentSetADT {
    private HashSet<String> studentIDs;

    public StudentSetADT() {
        studentIDs = new HashSet<>();
    }

    // Register a student
    public boolean addStudent(String id) {
        return studentIDs.add(id);
    }

    // Remove a student
    public boolean removeStudent(String id) {
        return studentIDs.remove(id);
    }

    // Check registration
    public boolean isRegistered(String id) {
        return studentIDs.contains(id);
    }

    // Display all students
    public void displayStudents() {
        System.out.println(studentIDs);
    }

    public static void main(String[] args) {
        StudentSetADT reg = new StudentSetADT();
        reg.addStudent("S101");
        reg.addStudent("S102");
        reg.addStudent("S101"); // duplicate ignored
        reg.displayStudents();
    }
}
