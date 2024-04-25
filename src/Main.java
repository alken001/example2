import Classes.*;

public class Main {
    public static void main(String[] args) {
        checkMyMinHeap();
    }

    private static void checkMyArrayList() {
        MyArrayList myArrayList =  new MyArrayList();
        myArrayList.add(11.5);
        myArrayList.add(10);
        myArrayList.add(9);
        myArrayList.add(8.7);
        myArrayList.add(7);
        myArrayList.add(0);
        myArrayList.set(0,2);
        myArrayList.addLast(-123);
        myArrayList.addFirst(123);
        for(int i = 0; i < myArrayList.size(); i++) {
            System.out.print( myArrayList.get(i) + " ");
        }
        System.out.println();
        myArrayList.sort();
        for(int i = 0; i < myArrayList.size(); i++) {
            System.out.print( myArrayList.get(i) + " ");
        }
        myArrayList.removeLast();
        myArrayList.removeFirst();
        myArrayList.remove(3);

        System.out.println();
        System.out.println(myArrayList.getLast());
        System.out.println(myArrayList.getFirst());
        System.out.println(myArrayList.get(3));

        System.out.println(myArrayList.indexOf(0));
        myArrayList.add(11.5);
        myArrayList.add(11.5);
        System.out.println(myArrayList.lastIndexOf(11.5));
        System.out.println();
        System.out.println(myArrayList.exists(6) ? "6 exists" : "6 doesn't exist");
        myArrayList.clear();
    }
    private static void checkMyLinkedList() {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(11);
        myLinkedList.add(10.5);
        myLinkedList.add(9);
        myLinkedList.add(8);
        myLinkedList.add(7);
        myLinkedList.add(0);
        myLinkedList.addLast(-123);
        myLinkedList.addFirst(123);
        for (Object item : myLinkedList) {
            System.out.print(item + " ");
        }
        System.out.println();

        myLinkedList.sort();
        for (Object item : myLinkedList) {
            System.out.print(item + " ");
        }

        myLinkedList.removeLast();
        myLinkedList.removeFirst();
        myLinkedList.remove(3);

        System.out.println();
        System.out.println(myLinkedList.getLast());
        System.out.println(myLinkedList.getFirst());
        System.out.println(myLinkedList.get(3));

        System.out.println(myLinkedList.indexOf(0));
        myLinkedList.add(11);
        myLinkedList.add(11);
        System.out.println(myLinkedList.lastIndexOf(11));
        System.out.println();
        System.out.println(myLinkedList.exists(6) ? "6 exists" : "6 doesn't exist");
        myLinkedList.clear();
    }
    private static void checkMyStack() {
        MyStack<Object> myStack = new MyStack<>();
        System.out.println(myStack.empty());
        myStack.push(12.5);
        myStack.push(11);
        System.out.println(myStack.empty());
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        System.out.println(myStack.push(19.230));
        System.out.println(myStack.pop());
    }
    private static void checkMyQueue() {
        MyQueue<Object> myQueue = new MyQueue<>();
        System.out.println(myQueue.empty());
        myQueue.enqueue(12.5);
        myQueue.enqueue(11);
        System.out.println(myQueue.empty());
        System.out.println(myQueue.size());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.enqueue(19.230));
        System.out.println(myQueue.dequeue());
    }
    private static void checkMyMinHeap() {
        MyMinHeap<Object> myMinHeap = new MyMinHeap<>();
        myMinHeap.insert(1);
        myMinHeap.insert(3);
        myMinHeap.insert(2);
        myMinHeap.insert(-5);
        System.out.println(myMinHeap.getMin());
        System.out.println(myMinHeap.size());
        System.out.println(myMinHeap.extractMin());
        System.out.println(myMinHeap.size());
        System.out.println(myMinHeap.extractMin());
        System.out.println(myMinHeap.getMin());
    }
}
