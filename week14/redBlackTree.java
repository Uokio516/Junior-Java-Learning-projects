class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    // 定義節點類別
    class Node {
        int key;
        Node left, right;
        boolean color;

        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }

    private Node root;

    // 新增節點
    public void insert(int key) {
        root = insert(root, key);
        root.color = BLACK;
    }

    // 將新節點插入到樹中
    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        // 如果右子節點是紅色且左子節點是黑色，就對節點進行左旋
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        // 如果左子節點是紅色且左子節點的左子節點也是紅色，就對節點進行右旋
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        // 如果左右子節點都是紅色，就對節點進行顏色翻轉
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    // 左旋
    private Node rotateLeft(Node node) {
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        right.color = node.color;
        node.color = RED;
        node.right.color = BLACK;
        return right;
        }
    // 右旋
    private Node rotateRight(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        left.color = node.color;
        node.color = RED;
        left.right.color = BLACK;
        return left;
    }

    // 顏色翻轉
    private void flipColors(Node node) {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    // 判斷節點顏色
    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        // 新增10個節點
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(90);
        tree.insert(100);
        tree.insert(110);
    }
}