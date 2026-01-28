import java.util.ArrayList;

/**
 * A generic max heap implementation using an array-based approach.
 *
 * This heap maintains the max heap property where each parent is greater than
 * or equal to its children. Supports insertion and extraction in O(log n) time.
 *
 * @param <E> the type of elements in the heap (must implement Comparable)
 */
public class SimpleMaxHeap<E extends Comparable<E>> {
    private ArrayList<E> heap;

    /**
     * Constructs an empty max heap.
     */
    public SimpleMaxHeap() {
        heap = new ArrayList<>();
    }

    /**
     * Returns the number of elements in the heap.
     */
    public int size() { return heap.size(); }

    /**
     * Checks if the heap is empty.
     */
    public boolean isEmpty() { return heap.isEmpty(); }

    /**
     * Swaps two elements in the heap.
     */
    private void swap(int i, int j) {
        E tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    /**
     * Moves an element up the heap to maintain the heap property.
     */
    private void siftUp(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (heap.get(idx).compareTo(heap.get(parent)) <= 0) break;
            swap(idx, parent);
            idx = parent;
        }
    }

    /**
     * Moves an element down the heap to maintain the heap property.
     */
    private void siftDown(int idx) {
        int n = heap.size();
        while (true) {
            int left = idx * 2 + 1;
            int right = idx * 2 + 2;
            int largest = idx;
            if (left < n && heap.get(left).compareTo(heap.get(largest)) > 0) largest = left;
            if (right < n && heap.get(right).compareTo(heap.get(largest)) > 0) largest = right;
            if (largest == idx) break;
            swap(idx, largest);
            idx = largest;
        }
    }

    /**
     * Inserts a value into the heap.
     *
     * @param value the value to insert (must not be null)
     */
    public void insert(E value) {
        if (value == null) return;
        heap.add(value);
        siftUp(heap.size() - 1);
    }

    /**
     * Returns the maximum element without removing it.
     *
     * @return the maximum element, or null if heap is empty
     */
    public E peek() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    /**
     * Removes and returns the maximum element.
     *
     * @return the maximum element, or null if heap is empty
     */
    public E extractMax() {
        if (heap.isEmpty()) return null;
        E top = heap.get(0);
        E last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return top;
    }

    /**
     * Displays the heap contents.
     */
    public void display() {
        System.out.println(heap.toString());
    }
}
