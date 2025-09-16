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
            System.out.print(1 + " ");
        } else {
            insertRecursive(root, value, 1);
        }
    }

    private void insertRecursive(Node node, int value, int depth) {
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
                System.out.print(depth + 1 + " ");
            } else {
                insertRecursive(node.left, value, depth + 1);
            }
        } else if (value > node.value) {
            if (node.right == null) {
                node.right = new Node(value);
                System.out.print(depth + 1 + " ");
            } else {
                insertRecursive(node.right, value, depth + 1);
            }
        }
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
    }
}
