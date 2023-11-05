package kap5_1_2_binarytrees_and_searchtrees;

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

    public final void add(int position, T value) {
        if (position < 1) throw new IllegalArgumentException("Position has to be > 0");

        Node<T> p = root, q = null; // p points at current, q points at parent of p

        // Acts as a counter:
        // ex, 45 gives 16 which is 10000 in binary. This can be bitshifted five times before reaching 0
        int filter = Integer.highestOneBit(position) >> 1;

        while (p != null && filter > 0) {

        }

        if (filter > 0) throw new IllegalArgumentException("Position has no parent");
        if (p != null) throw new IllegalArgumentException("Position already exists");


    }

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}
}

class Test {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();


    }
}