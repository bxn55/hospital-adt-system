import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Manages patient registration in the hospital system.
 * 
 * Maintains a registry of patients with unique IDs and associated names,
 * preserving insertion order for consistent display.
 */
public class PatientRegistry {
    private final Map<String, String> registry = new LinkedHashMap<>();

    /**
     * Registers a new patient with the given ID and name.
     *
     * @param id   unique patient identifier (must not be null or empty)
     * @param name patient's full name (must not be null)
     * @return true if registration successful, false if ID already exists or invalid input
     */
    public boolean register(String id, String name) {
        if (id == null || id.isEmpty() || name == null) return false;
        if (registry.containsKey(id)) return false;
        registry.put(id, name);
        return true;
    }

    /**
     * Checks if a patient is registered.
     *
     * @param id the patient ID to check
     * @return true if the patient is registered
     */
    public boolean isRegistered(String id) {
        return registry.containsKey(id);
    }

    /**
     * Retrieves the name of a registered patient.
     *
     * @param id the patient ID
     * @return the patient's name, or null if not registered
     */
    public String getName(String id) {
        return registry.get(id);
    }

    /**
     * Unregisters a patient from the system.
     *
     * @param id the patient ID to remove
     */
    public void unregister(String id) {
        registry.remove(id);
    }

    /**
     * Displays all registered patients.
     */
    public void display() {
        System.out.println(registry);
    }
}
