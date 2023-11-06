package kap4;

import java.util.Arrays;

public class ArrayQueue<T> {
    private T[] a;
    private int front = -1, rear = -1;
    private int size = 0;

    /** Array is given initial size/length of 16 */
    public ArrayQueue() {
        a = (T[]) new Object[16];
    }

    /** User specifies length */
    public ArrayQueue(int length) {
        a = (T[]) new Object[length];
    }

    public boolean isEmpty() { return size == 0; }

    public boolean enqueue(T value) {
        if (isEmpty()) {front = 0; rear = 0;}
        a[rear] = value;
        rear++;
        size++;
        System.out.println("front: " + front + " value: " + value + " rear: " + rear);
        return true;
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T value = a[front];
        a[front] = null;
        front++;
        size--;
        return value;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "a=" + Arrays.toString(a) +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        ArrayQueue<Integer> q = new ArrayQueue<>();
        q.enqueue(2);
        q.enqueue(5);
        q.enqueue(1);

        System.out.println(q);
    }
}