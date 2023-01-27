class AVLTree {
    private Node root;

    private class Node {
        int val;
        Node left, right;
        int height;

        Node(int val) {
            this.val = val;
            this.height = 1;
        }
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private int balanceFactor(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private Node rightRotate(Node node) {
        Node left = node.left;
        Node leftRight = left.right;
        left.right = node;
        node.left = leftRight;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        left.height = Math.max(height(left.left), height(left.right)) + 1;
        return left;
    }

    private Node leftRotate(Node node) {
        Node right = node.right;
        Node rightLeft = right.left;
        right.left = node;
        node.right = rightLeft;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        right.height = Math.max(height(right.left), height(right.right)) + 1;
        return right;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node node, int val) {
        if (node == null)
            return new Node(val);
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        } else
            return node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = balanceFactor(node);
        if (balance > 1 && val < node.left.val) {
            return rightRotate(node);
        }
        if (balance < -1 && val > node.right.val) {
            return leftRotate(node);
        }
        if (balance > 1 && val > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && val < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    
}