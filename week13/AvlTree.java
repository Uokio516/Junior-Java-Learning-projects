class Node {
    int key, height;
    Node left, right;
 
    //定義節點的建構子
    public Node(int key) {
        this.key = key;
        height = 1;
    }
}
 
public class AvlTree {
    Node root;
 
    //定義AVLTree的建構子
    AvlTree() {
        root = null;
    }
 
    //取得節點的高度
    int height(Node N) {
        if (N == null)
            return 0;
 
        return N.height;
    }
 
    //取得兩個整數中最大值
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
 
    //將節點旋轉左轉
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
 
        y.left = x;
        x.right = T2;
 
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        return y;
    }
 
    //將節點旋轉右轉
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
 
        x.right = y;
        y.left = T2;
 
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        return x;
    }
 
    //取得節點的平衡因子
    int getBalance(Node N) {
        if (N == null)
            return 0;
 
        return height(N.left) - height(N.right);
    }
 
    //插入節點
    Node insert(Node node, int key) {
 
        if (node == null)
            return (new Node(key));
 
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;
 
        node.height = 1 + max(height(node.left),
                              height(node.right));
 
        int balance = getBalance(node);
        if (balance > 1 && key < node.left.key)
        return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    //前序遍歷
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    }

