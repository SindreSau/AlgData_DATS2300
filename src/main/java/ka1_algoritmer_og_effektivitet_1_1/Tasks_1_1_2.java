package ka1_algoritmer_og_effektivitet_1_1;

import java.util.NoSuchElementException;

/**
 * Tasks for chapter 1.1.2
 * */
public class Tasks_1_1_2 {
    /*1*/
    // 6

    /*2*/
    public static int min(int[] a) {
        if (a.length < 1)
            throw new NoSuchElementException("Array is empty!");

        int m = 0; // Current minimum value index

        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[m]) m = i;
        }

        return m;
    }

    /*3*/
    // Returns the last greatest value
    public static int max(int[] a)
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Array is empty!");

        int m = 0;  // Current max value index

        for (int i = 1; i < a.length; i++)
        {
            if (a[i] >= a[m]) m = i;   //? Originally (a[i] > a[m]) m = i;
        }

        return m;

    } // maks
}
