package oblig3;

public class Oppgave2 {
    static class MinHeap {
        private int capacity = 10;
        private int size = 0;

        int[] items = new int[capacity];

        private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
        private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
        private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }

        private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
        private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
        private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

        private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
        private int rightChild(int index) { return items[getRightChildIndex(index)]; }
        private int parent(int index) { return items[getParentIndex(index)]; }

        private void swap(int indexOne, int indexTwo) {
            int temp = items[indexOne];
            items[indexOne] = items[indexTwo];
            items[indexTwo] = temp;
        }

        private void ensureExtraCapacity() {
            if (size == capacity) {
                items = java.util.Arrays.copyOf(items, capacity * 2);
                capacity *= 2;
            }
        }

        /**
         * Peeks at the root element(the smallest element) in the heap.
         * */
        public int peek() {
            if (size == 0) throw new IllegalStateException();
            return items[0];
        }

        /**
         * Removes the root element(the smallest element) from the heap.
         * */
        public int poll() {
            if (size == 0) throw new IllegalStateException();
            int item = items[0];
            items[0] = items[size - 1];
            size--;
            heapifyDown();
            return item;
        }

        /**
         * Adds an element to the heap, and then sorts it into the correct position.
         * */
        public void add(int item) {
            ensureExtraCapacity();
            items[size] = item;
            size++;
            heapifyUp();
        }

        /**
         * Sorts the heap from the bottom up.
         * */
        public void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && parent(index) > items[index]) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }

        /**
         * Sorts the heap from the top down.
         * */
        public void heapifyDown() {
            int index = 0;
            while (hasLeftChild(index)) {
                int smallerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                    smallerChildIndex = getRightChildIndex(index);
                }

                if (items[index] < items[smallerChildIndex]) {
                    break;
                } else {
                    swap(index, smallerChildIndex);
                }
                index = smallerChildIndex;
            }
        }

        public void print() {
            for (int i = 0; i < size; i++) {
                System.out.print(items[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 4, 1, 2, 6, 7};

        MinHeap mh = new MinHeap();
        for (Integer i: a) {
            mh.add(i);
        }

        mh.print(); // Should become 1, 2, 4, 5, 3, 6, 7
    }
}
