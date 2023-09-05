package kap2_nest_storst_verdi;

// V1
/*
public class TournamentTree {
    private Node root;

    private static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        Node(int value) {
            this.value = value;
        }
    }

    public TournamentTree(int[] array) {
        buildTree(array);
    }

    private void buildTree(int[] array) {
        int n = array.length;
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(array[i]);
        }

        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                nodes[i] = createParent(nodes[2 * i], nodes[2 * i + 1]);
            }
            if (n % 2 == 1) {
                nodes[n / 2] = nodes[n - 1];
            }
            n = (n + 1) / 2;
        }

        root = nodes[0];
    }

    private Node createParent(Node left, Node right) {
        Node parent = new Node(Math.max(left.value, right.value));
        parent.left = left;
        parent.right = right;
        left.parent = parent;
        right.parent = parent;
        return parent;
    }

    public int largestValue() {
        return root.value;
    }

    public int nextSmallestValue() {
        Node node = root;
        while (node.left != null) {
            node = node.left.value < node.right.value ? node.left : node.right;
        }
        return node.parent.value;
    }



    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node root, int i) {
        if (root == null) return;
        printTree(root.right, i + 1);
        for (int j = 0; j < i; j++) {
            System.out.print("   ");
        }
        System.out.println(root.value);
        printTree(root.left, i + 1);
    }

    public static void main(String[] args) {
        int[] array = {3, 8, 6, 20, 17, 9, 12, 15};
        TournamentTree tree = new TournamentTree(array);
        tree.printTree();

        System.out.println("Largest Value: " + tree.largestValue());
        System.out.println("Next Smallest Value: " + tree.nextSmallestValue());
    }
}*/


// V2
public class TournamentTree {
    public static void main(String[] args) {
        Node n = new Node(0);
        n.right = new Node(1);
    }

    private static class Node {
        int value;
        Node left, right, parent;

        Node(int value) {
            this.value = value;
        }
    }




}