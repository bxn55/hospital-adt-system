/**
 * A simple binary tree implementation for representing organization hierarchies.
 * 
 * Supports three types of tree traversals: preorder, inorder, and postorder.
 */
public class SimpleOrganizationTree {
    /**
     * Represents a node in the organization tree.
     */
    public static class Node {
        public String name;
        public Node left, right;

        /**
         * Constructs a tree node with the given department/position name.
         *
         * @param name the name of the department or position
         */
        public Node(String name) { 
            this.name = name; 
        }
    }

    public Node root;

    /**
     * Performs a preorder traversal (parent, left, right) of the tree.
     *
     * @param n the node to start traversal from
     */
    public void preorder(Node n) {
        if (n == null) return;
        System.out.print(n.name + " ");
        preorder(n.left);
        preorder(n.right);
    }

    /**
     * Performs an inorder traversal (left, parent, right) of the tree.
     *
     * @param n the node to start traversal from
     */
    public void inorder(Node n) {
        if (n == null) return;
        inorder(n.left);
        System.out.print(n.name + " ");
        inorder(n.right);
    }

    /**
     * Performs a postorder traversal (left, right, parent) of the tree.
     *
     * @param n the node to start traversal from
     */
    public void postorder(Node n) {
        if (n == null) return;
        postorder(n.left);
        postorder(n.right);
        System.out.print(n.name + " ");
    }
}
