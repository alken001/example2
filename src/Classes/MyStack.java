package Classes;

public class MyStack<T> {
    MyArrayList<T> myStack = new MyArrayList<>();

    public boolean empty() {
        return myStack.size() == 0;
    }
    public int size() {
        return myStack.size();
    }
    public T peek() {
        if(empty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return (T) myStack.getLast();
    }
    public T push(T item) {
        myStack.addLast(item);
        return (T) myStack.getLast();
    }
    public T pop() {
        if(empty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T item = (T) myStack.getLast();
        myStack.removeLast();
        return item;
    }
}