public class pratice {
static class Node{
    int data;
    Node left,right;

    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public static Node insert(Node root,int val){
    if(root==null){
        root =new Node(val);
        return root;
    }

    if(root.data>val){
        root.left= insert(root.left,val);
    }

    if(root.data<val){
        root.right= insert(root.right,val);
    }
    return root;
}
public static void inorder(Node root){
    if(root==null){
        return ;
    }
    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
}



public static void main(String[] args) {
    int value []={1,5,2,4,6,8,7,9,3,10};
    Node root=null;

    for(int i=0;i<value.length;i++){
        root=insert(root, value[i]);
    }

    inorder(root);
    System.out.println();
}
    
}