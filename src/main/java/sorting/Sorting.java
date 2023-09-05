package sorting;

import utils.Randperm;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] a = Randperm.getRandomArray(10_000, 0, 50000);
        System.out.println(Arrays.toString(a));
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * Sorts in place using the quicksort-algorithm
     */
    public static void quickSort(int[] arr) {
        int lowIndex = 0;
        int highIndex = arr.length - 1;

        quickSort(arr, lowIndex, highIndex);
    }

    private static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex)
            return;

        int partitionIndex = partition(arr, lowIndex, highIndex);
        quickSort(arr, lowIndex, partitionIndex - 1);
        quickSort(arr, partitionIndex, highIndex);
    }

    private static int partition(int[] arr, int lowIndex, int highIndex) {
        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {

            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(arr, leftPointer, rightPointer);
        }
        swap(arr, leftPointer, highIndex);
        return rightPointer;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
