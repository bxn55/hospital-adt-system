import java.util.HashSet;
import java.util.Set;

/**
 * A simple set implementation for managing student records.
 * 
 * Uses a hash set for O(1) average-case operations on add, remove, and contains.
 */
public class SimpleStudentSet {
    private Set<String> students = new HashSet<>();

    /**
     * Adds a student ID to the set.
     *
     * @param id the student ID to add
     * @return true if the ID was added (wasn't already present)
     */
    public boolean add(String id) { 
        return students.add(id); 
    }

    /**
     * Removes a student ID from the set.
     *
     * @param id the student ID to remove
     * @return true if the ID was removed (was present)
     */
    public boolean remove(String id) { 
        return students.remove(id); 
    }

    /**
     * Checks if a student ID is in the set.
     *
     * @param id the student ID to check
     * @return true if the ID is in the set
     */
    public boolean contains(String id) { 
        return students.contains(id); 
    }

    /**
     * Returns the number of students in the set.
     */
    public int size() { 
        return students.size(); 
    }

    /**
     * Displays all student IDs in the set.
     */
    public void display() { 
        System.out.println(students); 
    }
}
