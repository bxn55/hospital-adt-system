public class MaxHeapADT {
    // Triage queue using Java's PriorityQueue.
    public static class Patient {
        public final String name;
        public final int severity; // higher = more severe
        public final long arrival; // lower = arrived earlier

        public Patient(String name, int severity, long arrival) {
            this.name = name;
            this.severity = severity;
            this.arrival = arrival;
        }

        @Override
        public String toString() {
            return name + "(sev=" + severity + ",arr=" + arrival + ")";
        }
    }

    private java.util.PriorityQueue<Patient> pq;

    public MaxHeapADT() {
        // Comparator: higher severity first; if tie, earlier arrival first
        pq = new java.util.PriorityQueue<>((a, b) -> {
            if (a.severity != b.severity) return Integer.compare(b.severity, a.severity);
            return Long.compare(a.arrival, b.arrival);
        });
    }

    public void insert(Patient p) { if (p != null) pq.add(p); }
    public Patient extractMax() { return pq.poll(); }
    public Patient peek() { return pq.peek(); }
    public boolean isEmpty() { return pq.isEmpty(); }
    public int size() { return pq.size(); }

    public void display() {
        System.out.println("Queue size: " + pq.size());
        Patient top = pq.peek();
        System.out.println("Top: " + (top == null ? "(empty)" : top));
    }

    public static void main(String[] args) {
        MaxHeapADT triage = new MaxHeapADT();
        long arrival = 1;

        triage.insert(new Patient("Alice", 5, arrival++));
        triage.insert(new Patient("Bob", 3, arrival++));
        triage.insert(new Patient("Charlie", 5, arrival++));
        triage.insert(new Patient("Diana", 8, arrival++));
        triage.insert(new Patient("Edward", 5, arrival++));

        triage.display();
        System.out.println("\nAttending patients in order of priority:\n");
        while (!triage.isEmpty()) {
            System.out.println("Attending: " + triage.extractMax());
        }
    }
}
