import java.util.Scanner;
import java.util.ArrayList;

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

    public void printLeaves() {
        ArrayList<Integer> leaves = new ArrayList<>();
        findLeaves(root, leaves);
        for (int leaf : leaves) {
            System.out.println(leaf);
        }
    }

    private void findLeaves(Node node, ArrayList<Integer> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.value);
        }
        findLeaves(node.left, leaves);
        findLeaves(node.right, leaves);
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

        tree.printLeaves();
    }
}
