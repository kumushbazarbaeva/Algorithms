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

    public boolean isAVLTree() {
        return checkBalance(root) != -1;
    }

    private int checkBalance(Node node) {
        if (node == null) {
            return 0;
        }

        var leftHeight = checkBalance(node.left);
        var rightHeight = checkBalance(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

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

        System.out.println(tree.isAVLTree() ? "YES" : "NO");
    }
}
