/**
 * Represents a patient in the hospital triage system.
 * 
 * Patients are ordered by severity (higher is more urgent) and then by arrival
 * time (earlier arrivals have priority if severities are equal).
 */
public class Patient implements Comparable<Patient> {
    private final String id;
    private final String name;
    private final int severity;
    private final long arrival;

    /**
     * Constructs a Patient with the given information.
     *
     * @param id       unique patient identifier
     * @param name     patient's full name
     * @param severity severity level (1-10, higher is more urgent)
     * @param arrival  arrival sequence number (lower = earlier)
     */
    public Patient(String id, String name, int severity, long arrival) {
        this.id = id;
        this.name = name;
        this.severity = severity;
        this.arrival = arrival;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getSeverity() { return severity; }
    public long getArrival() { return arrival; }

    /**
     * Compares patients by severity (descending), then by arrival time (ascending).
     *
     * @param o the other patient to compare to
     * @return negative if this patient has lower priority, positive if higher
     */
    @Override
    public int compareTo(Patient o) {
        if (this.severity != o.severity) return Integer.compare(this.severity, o.severity);
        return Long.compare(o.arrival, this.arrival) * -1; // earlier arrival higher priority
    }

    @Override
    public String toString() {
        return id + ":" + name + "(sev=" + severity + ",arr=" + arrival + ")";
    }
}
