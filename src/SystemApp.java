import java.util.Scanner;

/**
 * Main interactive application for the hospital patient triage system.
 * 
 * This system demonstrates practical use of Abstract Data Types (ADTs):
 * - Max Heap for priority-based patient queue
 * - Registry for patient management
 * - Binary Tree for organization structure
 * 
 * Users can register patients, manage triage priorities, and view
 * the organizational hierarchy through different tree traversal methods.
 */
public class SystemApp {
    /**
     * Entry point for the hospital system application.
     * Provides an interactive menu for managing patients and viewing organization structure.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleMaxHeap<Patient> triage = new SimpleMaxHeap<>();
        PatientRegistry registry = new PatientRegistry();
        SimpleOrganizationTree org = buildSampleOrg();

        long arrivalCounter = 1;

        while (true) {
            printMenu();
            String choice = sc.nextLine().trim();
            if (choice.equals("0")) break;
            switch (choice) {
                case "1": // register patient
                    System.out.print("Enter patient ID: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Enter patient name: ");
                    String name = sc.nextLine().trim();
                    boolean ok = registry.register(id, name);
                    System.out.println(ok ? "Registered." : "ID already registered or invalid.");
                    break;
                case "2": // add to triage
                    System.out.print("Enter registered patient ID: ");
                    String pid = sc.nextLine().trim();
                    if (!registry.isRegistered(pid)) { System.out.println("Not registered."); break; }
                    System.out.print("Enter severity (1-10, higher = worse): ");
                    int sev = Integer.parseInt(sc.nextLine().trim());
                    Patient p = new Patient(pid, registry.getName(pid), sev, arrivalCounter++);
                    triage.insert(p);
                    System.out.println("Added to triage: " + p);
                    break;
                case "3": // attend next
                    Patient next = triage.extractMax();
                    System.out.println(next == null ? "No patients in triage." : "Attending: " + next);
                    break;
                case "4": // list registered
                    System.out.print("Registered patients: "); registry.display();
                    break;
                case "5": // peek
                    System.out.println("Next in triage: " + triage.peek());
                    break;
                case "6": // show departments
                    System.out.print("Preorder: "); org.preorder(org.root); System.out.println();
                    System.out.print("Inorder: "); org.inorder(org.root); System.out.println();
                    System.out.print("Postorder: "); org.postorder(org.root); System.out.println();
                    break;
                default:
                    System.out.println("Unknown option.");
            }
            System.out.println();
        }

        sc.close();
        System.out.println("Exiting system. Goodbye.");
    }

    /**
     * Displays the interactive menu options to the user.
     */
    private static void printMenu() {
        System.out.println("--- Hospital System ---");
        System.out.println("1) Register patient");
        System.out.println("2) Add registered patient to triage");
        System.out.println("3) Attend next patient");
        System.out.println("4) List registered patients");
        System.out.println("5) Peek next triage patient");
        System.out.println("6) Show department traversals");
        System.out.println("0) Exit");
        System.out.print("Choice: ");
    }

    /**
     * Builds a sample organization tree representing the hospital structure.
     *
     * @return an OrganizationTree with a sample hospital hierarchy
     */
    private static SimpleOrganizationTree buildSampleOrg() {
        SimpleOrganizationTree org = new SimpleOrganizationTree();
        org.root = new SimpleOrganizationTree.Node("Hospital");
        org.root.left = new SimpleOrganizationTree.Node("Emergency");
        org.root.right = new SimpleOrganizationTree.Node("Surgery");
        org.root.left.left = new SimpleOrganizationTree.Node("Triage");
        org.root.left.right = new SimpleOrganizationTree.Node("ER Ward");
        org.root.right.left = new SimpleOrganizationTree.Node("OR 1");
        org.root.right.right = new SimpleOrganizationTree.Node("OR 2");
        return org;
    }
}
