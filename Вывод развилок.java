import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

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

    public void printNodesWithTwoChildren() {
        ArrayList<Integer> nodesWithTwoChildren = new ArrayList<>();
        findNodesWithTwoChildren(root, nodesWithTwoChildren);
        Collections.sort(nodesWithTwoChildren);
        for (int node : nodesWithTwoChildren) {
            System.out.println(node);
        }
    }

    private void findNodesWithTwoChildren(Node node, ArrayList<Integer> nodesWithTwoChildren) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.right != null) {
            nodesWithTwoChildren.add(node.value);
        }
        findNodesWithTwoChildren(node.left, nodesWithTwoChildren);
        findNodesWithTwoChildren(node.right, nodesWithTwoChildren);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        
        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            tree.insert(number);
        }

        tree.printNodesWithTwoChildren();
    }
}
