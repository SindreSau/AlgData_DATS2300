package kap4;

public class LinkedStack<T> {

    private static final class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> head;
    private int size;

    public LinkedStack() {
        head = null;
        size = 0;
    }

    public void add(T value) {
        head = new Node<T>(value, head);
        size++;
    }

    public T peek() {
        return head.value;
    }

    public void pop() {
        head = head.next;
        size--;
    }

    public void clear() {
        int length = size;
        for (int i = 0; i < length; i++) {
            head = head.next;
            size--;
        }
    }

    @Override
    public String toString() {
        if(size > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Stack: ");
            Node<T> current = head;
            while (current != null) {
                sb.append(current.value + " ");
                current = current.next;
            }
            return sb.toString();
        }
        return "Stack empty";
    }

    public int getSize() {
        return size;
    }
}

class run {
    public static void main(String[] args) {
        LinkedStack<Integer> s = new LinkedStack<>();
        s.add(1);
        s.add(5);
        s.add(2);
        s.add(9);
        System.out.println(s.peek());
        s.pop();
        System.out.println(s);
        System.out.println(s.getSize());

        s.clear();
        System.out.println(s);
        System.out.println(s.getSize());
    }
}

class random {
    public static int getRandomInt(int low, int high) {
        return (int) (Math.random() * (high - low) + low);
    }
}