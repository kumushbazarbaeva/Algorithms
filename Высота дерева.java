import java.util.Scanner;

class BinarySearchTree {
    static class Node {
        int value;
        Node left, right;
        
        Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insertRecursive(root, value);
        }
    }

    private void insertRecursive(Node node, int value) {
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                insertRecursive(node.left, value);
            }
        } else if (value > node.value) {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                insertRecursive(node.right, value);
            }
        }
    }

    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = heightRecursive(node.left);
        int rightHeight = heightRecursive(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var tree = new BinarySearchTree();
        
        while (true) {
            var number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            tree.insert(number);
        }

        System.out.println(tree.height());
    }
}
