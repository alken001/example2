package Classes;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {
    private Object[] list;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        list = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public Object[] getList() {
        return list;
    }

    public void setList(Object[] list) {
        size = list.length;
        this.list = list;
    }

    @Override
    public void add(T item) {
        if (size >= list.length) {
            increaseBuffer();
        }
        list[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        list[index] = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        if (size >= list.length) {
            increaseBuffer();
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) list[index];
    }

    @Override
    public T getFirst() {
        return (T) list[0];
    }

    @Override
    public T getLast() {
        return (T) list[size - 1];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (size == 0) {
            return;
        }
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (compare(list[j], list[j + 1])) {
                    Object temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(object)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        System.arraycopy(list, 0, array, 0, size);
        return array;
    }

    @Override
    public void clear() {
        list = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void increaseBuffer() {
        Object[] newList = new Object[size * 2];
        System.arraycopy(list, 0, newList, 0, size);
        list = newList;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
    }

    private boolean compare(Object obj1, Object obj2) {
        if (obj1 instanceof Integer && obj2 instanceof Integer) {
            return ((Integer) obj1 > (Integer) obj2);
        } else if (obj1 instanceof Double && obj2 instanceof Double) {
            return ((Double) obj1 > (Double) obj2);
        } else if (obj1 instanceof Integer && obj2 instanceof Double) {
            return ((Integer) obj1 > (Double) obj2);
        } else if (obj1 instanceof Double && obj2 instanceof Integer) {
            return ((Double) obj1 > (Integer) obj2);
        } else {
            throw new IllegalArgumentException("Unsupported types for comparison: " + obj1.getClass() + " and " + obj2.getClass());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return (T) list[currentIndex++];
            } else {
                throw new NoSuchElementException("There is no next element");
            }
        }
    }
}
