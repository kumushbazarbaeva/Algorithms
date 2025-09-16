class MyHashMap {
    private static final int SIZE = 1000;
    private Node[] buckets;

    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = buckets[index];
        
        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        
        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public int get(int key) {
        int index = getIndex(key);
        Node head = buckets[index];
        
        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        
        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node head = buckets[index];
        Node prev = null;
        
        while (head != null) {
            if (head.key == key) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }
}
