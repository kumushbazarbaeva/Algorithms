import java.util.Scanner;

class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int value) {
        heap[size] = value;
        siftUp(size);
        size++;
    }

    public int extractMax() {
        int max = heap[0];
        heap[0] = heap[--size];
        siftDown(0);
        return max;
    }

    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap[i] <= heap[parent]) break;
            swap(i, parent);
            i = parent;
        }
    }

    private void siftDown(int i) {
        while (2 * i + 1 < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = left;

            if (right < size && heap[right] > heap[left]) {
                largest = right;
            }

            if (heap[i] >= heap[largest]) break;
            swap(i, largest);
            i = largest;
        }
    }

    private void swap(int i, int j) {
        var temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        var heap = new MaxHeap(n);

        for (int i = 0; i < n; i++) {
            int command = scanner.nextInt();
            if (command == 0) {
                int value = scanner.nextInt();
                heap.insert(value);
            } else {
                System.out.println(heap.extractMax());
            }
        }
    }
}
