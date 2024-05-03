public class TreePreorder {
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
//making a recursive function
    static class InnerTreePreorder {
        static int idx = -1;  //initalize the index value by -1

        public static Node buildTree(int[] node) {  //making  a function
            idx++;  // firstly increase the index value 
            if (node[idx] == -1) {  
                return null;
            }
            //making a node
            Node newNode = new Node(node[idx]);
            //we have to make left and right subtree 
            newNode.left = buildTree(node);  // here = symbol used for jodne or adding
            newNode.right = buildTree(node);

            return newNode;
        }
    }

    public static void main(String[] args) {
        int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        //calling the recursive function...........
        Node root = InnerTreePreorder.buildTree(node);
        System.out.println(root.data);
    }
}
// time complexity for preorder is O(1).........