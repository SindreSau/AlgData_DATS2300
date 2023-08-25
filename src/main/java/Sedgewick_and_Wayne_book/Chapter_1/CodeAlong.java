package Sedgewick_and_Wayne_book.Chapter_1;

public class CodeAlong {

    public static void main(String[] args) {

        //* Implementation of BinarySearch
        int[] a = {1, 3, 4, 5, 7, 9, 11}; //a.length = 7, low = 0, high = 6
        int toFind = 11;
        int index = BinarySearch(a, toFind);
        if (index > 0) System.out.println(toFind + " exists at index " + index);
        else System.out.println(toFind + " does not exist in your array");
    }

    /**
     * Search for specified number in specified array. The array must be sorted for the algorithm to work!
     * @param array
     * @param number
     * @return Index in array if found, -1 if not found
     * */
    public static int BinarySearch(int[] array, int number) {
        int low = 0, high = array.length - 1;

        while(low <= high) {
            // int mid = (low + high) / 2; could trigger int overflow issue
            int mid = low + (high - low) / 2; //Gives same result as the above!

            if (number == array[mid]) {
                return mid;
            }
            else if (number < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }


    // Loop declaration
    public static void printForLoop(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    /** Shows how a for loop kind of works i guess */
    public static void printForWhile(int[] array) {
        int i = 0;
        while (i < array.length){
            System.out.println(array[i]);
            i++;
        }
    }
}
