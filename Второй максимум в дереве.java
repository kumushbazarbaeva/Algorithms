import java.util.Scanner;

class BinarySearchTree {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public Node findSecondLargest(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return null;
        }
        Node current = root;
        while (current != null) {
            if (current.right == null) {
                return current.left != null ? findMax(current.left) : current;
            }
            if (current.right != null && current.right.left == null && current.right.right == null) {
                return current;
            }
            current = current.right;
        }
        return null;
    }

    public Node findMax(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        var tree = new BinarySearchTree();
        var scanner = new Scanner(System.in);
        var root = (Node) null;
        while (true) {
            var number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            root = tree.insert(root, number);
        }
        var secondLargest = tree.findSecondLargest(root);
        System.out.println(secondLargest.value);
    }
}
