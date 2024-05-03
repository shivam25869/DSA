public class DeleteNode {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // Insert
        public static Node insert(Node root, int val) {
            if (root == null) {
                root = new Node(val);
                return root;
            }
            if (root.data > val) {
                root.left = insert(root.left, val);
            } else {
                root.right = insert(root.right, val);
            }
            return root;
        }

        // Search
        public static boolean search(Node root, int key) {
            if (root == null) {
                return false;
            }
            if (root.data == key) {
                return true;
            }
            if (root.data > key) {
                return search(root.left, key);
            } else {
                return search(root.right, key);
            }
        }

        // Inorder
        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // Delete
        public static Node delete(Node root, int val) {
            if (root == null) {
                return root;
            }
            if (root.data < val) {
                root.right = delete(root.right, val);
            } else if (root.data > val) {
                root.left = delete(root.left, val);
            } else {
                // Case 1: no child or one child
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                // Case 2: two children
                Node IS = findInorderSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
            return root;
        }

        // Inorder Successor
        public static Node findInorderSuccessor(Node root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        int value[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        // Inserting nodes
        for (int i = 0; i < value.length; i++) {
            root = Node.insert(root, value[i]);
        }

        // Calling inorder
        Node.inorder(root);
        System.out.println();

        root = Node.delete(root, 1);
        Node.inorder(root);
    }
}
