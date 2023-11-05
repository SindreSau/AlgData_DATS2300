package oblig3;

public class Oppgave5 {

    /**
     * Binary Search Tree
     * */
    static class SbinTree {
        private class Node {
            int value;
            Node left, right;

            Node(int value) {
                this.value = value;
                left = right = null;
            }
        }

        private Node root;

        SbinTree() {
            root = null;
        }

        /**
         * Inserts a value into the tree.
         * */
        public void insert(int value) {
            root = insertRec(root, value);
        }

        /**
         * Recursive helper function for insert.
         * */
        private Node insertRec(Node root, int value) {
            if (root == null) {
                root = new Node(value);
                return root;
            }

            if (value < root.value) {
                root.left = insertRec(root.left, value);
            } else if (value > root.value) {
                root.right = insertRec(root.right, value);
            }

            return root;
        }

        /**
         * Searches for a value in the tree.
         * */
        public boolean search(int value) {
            return searchRec(root, value);
        }

        /**
         * Recursive helper function for search.
         * */
        private boolean searchRec(Node root, int value) {
            if (root == null) {
                return false;
            }

            if (value == root.value) {
                return true;
            } else if (value < root.value) {
                return searchRec(root.left, value);
            } else {
                return searchRec(root.right, value);
            }

        }

        /**
         * Deletes a value from the tree.
         * */
        public void delete(int value) {
            root = deleteRec(root, value);
        }

        /**
         * Recursive helper function for delete.
         * */
        private Node deleteRec(Node root, int value) {
            if (root == null) {
                return root;
            }

            if (value < root.value) {
                root.left = deleteRec(root.left, value);
            } else if (value > root.value) {
                root.right = deleteRec(root.right, value);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                root.value = minValue(root.right);
                root.right = deleteRec(root.right, root.value);
            }

            return root;
        }

        /**
         * Finds the smallest value in the tree.
         * */
        private int minValue(Node root) {
            int minv = root.value;
            while (root.left != null) {
                minv = root.left.value;
                root = root.left;
            }
            return minv;
        }

        /**
         * Prints the tree in order.
         * */
        public void printInOrder() {
            System.out.println();
            printInOrderRec(root);
        }

        /**
         * Recursive helper function for printInOrder.
         * */
        private void printInOrderRec(Node root) {
            if (root != null) {
                printInOrderRec(root.left);
                System.out.print(root.value + " ");
                printInOrderRec(root.right);
            }
        }

        /**
         * Prints the tree in pre order.
         * */
        public void printPreOrder() {
            System.out.println();
            printPreOrderRec(root);
        }

        /**
         * Recursive helper function for printPreOrder.
         * */
        private void printPreOrderRec(Node root) {
            if (root != null) {
                System.out.print(root.value + " ");
                printPreOrderRec(root.left);
                printPreOrderRec(root.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 7, 10, 8, 9, 1, 2, 6};

        SbinTree sbt = new SbinTree();
        for (Integer i : a) {
            sbt.insert(i);
        }

        sbt.printPreOrder();
        sbt.printInOrder();
    }
}
