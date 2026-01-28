public class OrganizationTreeADT {
    private static class EmployeeNode {
        String name;
        EmployeeNode left, right;

        EmployeeNode(String name) {
            this.name = name;
            left = right = null;
        }
    }

    EmployeeNode root;

    // Inorder traversal
    public void inorder(EmployeeNode node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.name + " ");
        inorder(node.right);
    }

    // Preorder traversal
    public void preorder(EmployeeNode node) {
        if (node == null) return;
        System.out.print(node.name + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder traversal
    public void postorder(EmployeeNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.name + " ");
    }

    public static void main(String[] args) {
        OrganizationTreeADT org = new OrganizationTreeADT();

        org.root = new EmployeeNode("CEO");
        org.root.left = new EmployeeNode("Manager A");
        org.root.right = new EmployeeNode("Manager B");
        org.root.left.left = new EmployeeNode("Employee 1");
        org.root.left.right = new EmployeeNode("Employee 2");

        System.out.print("Preorder: ");
        org.preorder(org.root);
        System.out.print("\nInorder: ");
        org.inorder(org.root);
        System.out.print("\nPostorder: ");
        org.postorder(org.root);
        System.out.println();
    }
}
