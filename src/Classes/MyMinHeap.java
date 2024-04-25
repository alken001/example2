package Classes;

public class MyMinHeap<T> {
    MyArrayList<T> myHeap;
    public MyMinHeap() {
        myHeap = new MyArrayList<>();
    }
    public boolean empty() {
        return myHeap.size() == 0;
    }
    public int size() {
        return myHeap.size();
    }
    public T getMin() {
        if (empty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return (T) myHeap.get(0);
    }

    public T extractMin() {
        if (empty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = (T) myHeap.get(0);
        T last = (T) myHeap.getLast();
        myHeap.set(0, last);
        myHeap.removeLast();
        heapify(0);
        return min;
    }
    public void insert(T item) {
        myHeap.addLast(item);
        traverseUp(myHeap.size() - 1);
    }
    private void heapify(int index) {
        int smallest = index;
        int left = leftChildOf(index);
        int right = rightChildOf(index);

        if (left < myHeap.size() && compare(myHeap.get(left), myHeap.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < myHeap.size() && compare(myHeap.get(right), myHeap.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    private void traverseUp(int index) {
        while (index > 0 && compare(myHeap.get(index),myHeap.get(parentOf(index))) < 0) {
            swap(index, parentOf(index));
            index = parentOf(index);
        }
    }

    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        T temp = (T) myHeap.get(index1);
        myHeap.set(index1, myHeap.get(index2));
        myHeap.set(index2, temp);
    }

    private int compare(Object obj1, Object obj2) {
        return ((Comparable<T>) obj1).compareTo((T) obj2);
    }
}