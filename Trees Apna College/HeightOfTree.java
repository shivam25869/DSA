public class HeightOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Recursive function to find the height of the tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            // Compute the height of each subtree
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            // Use the larger one
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        // Building the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Calculate and print the height of the tree
          System.out.println(height(root)); 
          
      
    }
}
