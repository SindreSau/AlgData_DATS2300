package kap5_1_2_binarytrees_and_searchtrees;

import java.util.ArrayDeque;

public class BinaryTree<T> {
    private class Node<T> {
        T value;
        Node left, right;

        Node(T value) {
            this.value = value;
            left = right = null;
        }

        Node addLeftChild(T value) {
            left = new Node(value);
            return left;
        }

        Node addRightChild(T value) {
            right = new Node(value);
            return right;
        }
    }

    private Node root;
    private int size;


    public BinaryTree() {
        root = null;
        size = 0;
    }

    public BinaryTree(int[] position, T[] value) {
        if (position.length > value.length)
            throw new IllegalArgumentException("Too many values in relation to positions");

        for (int i = 0; i < position.length; i++) add(position[i], value[i]);
    }

    public final void add(int position, T value) {
        if (position < 1)
            throw new IllegalArgumentException("Position has to be > 0");

        Node<T> p = root, q = null; // p points at current, q points at parent of p

        // Acts as a counter:
        // ex, 45 gives 16 which is 10000 in binary. This can be bitshifted five times before reaching 0
        int filter = Integer.highestOneBit(position) >> 1;

        while (p != null && filter > 0) {
            q = p;
            // bitwise and: ex, pos=5(101) & filter=2(10) -> 101 & 010 = 000 -> p.right
            p = (position & filter) == 0 ? p.left : p.right;
            filter >>= 1;
        }

        if (filter > 0)
            throw new IllegalArgumentException("Position has no parent");
        if (p != null)
            throw new IllegalArgumentException("Position already exists");

        p = new Node<>(value);

        if (q == null) root = p;
        // If last bit in position is 0, it means we go left from parent. Else we go right from parent if last bit is 1.
        else if ((position & 1) == 0) q.left = p;
        else q.right = p;

        size++;
    }

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}

    public Node<T> findNode(int position) {
        if (position < 1) return null;

        Node<T> p = root;
        int filter = Integer.highestOneBit(position) >> 1;

        for (; p!= null && filter > 0; filter >>= 1)
            p = (position & filter) == 0 ? p.left : p.right;

        return p;
    }

    public boolean exists(int position) {
        return findNode(position) != null;
    }

    public T getValue(int position) {
        if (exists(position))
            return findNode(position).value;
        else
            throw new IllegalArgumentException("Invalid position");
    }

    public T update(int position, T value) {
        Node<T> p = findNode(position);

        if (p == null)
            throw new IllegalArgumentException("Invalid position");

        T oldValue = p.value;
        p.value = value;

        return oldValue;
    }

    public void printLevelOrder() {
        if (isEmpty()) return;

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Node<T>> que = new ArrayDeque<>();
        que.add(root);

        while (!que.isEmpty()) {
            Node<T> p = que.pop();
            sb.append(p.value);

            if (p.left != null) que.add(p.left);
            if (p.right != null) que.add(p.right);
        }

        System.out.println(sb);
    }

    public void printPreOrder() {
        if (isEmpty()) return;

        StringBuilder sb = new StringBuilder();
        printPreOrder(root, sb);
        System.out.println(sb);
    }

    private void printPreOrder(Node<T> p, StringBuilder sb) {
        if (p == null) return;
        sb.append(p.value);
        printPreOrder(p.left, sb);
        printPreOrder(p.right, sb);
    }

    public void printInOrder() {
        if (isEmpty()) return;

        StringBuilder sb = new StringBuilder();
        printInOrder(root, sb);
        System.out.println(sb);
    }

    private void printInOrder(Node<T> p, StringBuilder sb) {
        if (p == null) return;
        printInOrder(p.left, sb);
        sb.append(p.value);
        printInOrder(p.right, sb);
    }

    public void printPostOrder() {
        if (isEmpty()) return;
        StringBuilder sb = new StringBuilder();
        printPostOrder(root, sb);
        System.out.println(sb);
    }

    private void printPostOrder(Node<T> p, StringBuilder sb) {
        if (p == null) return;
        printPostOrder(p.left, sb);
        printPostOrder(p.right, sb);
        sb.append(p.value);
    }

    /**
    * toString method that prints the tree in a readable format.
    * */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb, 0);
        return sb.toString();
    }

    private void toString(Node<T> p, StringBuilder sb, int level) {
        if (p == null) return;
        toString(p.right, sb, level + 1);
        for (int i = 0; i < level; i++) sb.append("       ");
        sb.append(p.value).append("\n");
        toString(p.left, sb, level + 1);
    }
}

class Test {
    public static void main(String[] args) {
        BinaryTree<Character> bt = new BinaryTree<>();

        for (int i = 0; i < 7; i++) {
            bt.add(i+1, (char) ('A' + i));
        }

        bt.printLevelOrder();
        bt.printPreOrder();
        bt.printInOrder();
        bt.printPostOrder();
    }
}