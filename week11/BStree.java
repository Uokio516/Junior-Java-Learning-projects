class Node {
    int key;
    Node left, right;
 
    //定義建構子
    public Node(int item) {
        key = item;
        left = right = null;
    }
}
 
public class BStree {
    Node root;
 
    //定義建構子
    BStree() {
        root = null;
    }
 
    //插入節點
    void insert(int key) {
       root = insertRec(root, key);
    }
     
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
 
        return root;
    }
 

    
    void inorder()  {
       inorderRec(root);
    }
 
    
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
 
    public static void main(String[] args) {
        BStree tree = new BStree();
 
        //插入節點
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
 
        //印出結果
        tree.inorder();
    }
}
