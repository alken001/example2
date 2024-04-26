package Classes;

public class MyQueue<T> {
    MyLinkedList<T> myQueue = new MyLinkedList<>();
    public boolean empty() {
        return myQueue.size() == 0;
    }
    public int size() {
        return myQueue.size();
    }
    public T peek() {
        return myQueue.getFirst();
    }
    public T enqueue(T item) {
        myQueue.add(item);
        return item;
    }
    public T dequeue() {
        T item = peek();
        myQueue.removeFirst();
        return item;
    }
}