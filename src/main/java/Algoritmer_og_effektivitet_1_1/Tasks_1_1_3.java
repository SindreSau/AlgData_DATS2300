package Algoritmer_og_effektivitet_1_1;

import java.io.IOException;
import java.util.NoSuchElementException;

public class Tasks_1_1_3 {
    /*1*/
    // Mergesort, bubblesort, quicksort, blocksort

    /*2*/
    /*
    {10, 5, 7, 2, 9, 1, 3, 8, 4, 6}
    2, rettelse fra "boka". her er det både en tabelloperasjon og en sammenligning
    1, det opprettes en hjelpevariabel m for å bære maks-verdien
    1, variabelen i opprettes som en teller i forloopen
    n, i forloopen sjekkes det om i er mindre enn arraets lengde
    n - 1, i++ gjøres for de første n gangene av loopen, men siste loop-runden vil i < a.length returnere false og i++ vil ikke gjennomføres
    3x n - 1, sjekken: if(a[i] > a[m]) m = i; gjøres for arrayets lengde minus 1 (siden vi starter med i = 1):
        Det over inkluderer to tabelloperasjoner og en sammenligning!
    x, antallet ganger sammenligninga over er sann
    1, vi returnerer verdien i m

    UTREGNING av overstående:
    5 + n + 4(n-1) + x = 5n + 1 + x

    Det gitte arrayet har x = 0, siden det første elementet er det største
    n vil være lengden av arrayet, altså 10
    n-1 vil da være 9
    SVARET PÅ OPPGAVEN BLIR DA:
    * 51
    */

    /*3*/
    /*
    * x blir her 9, så svaret blir da 60
    */

    /*4*/
    /*
    * x blir her 4, og svaret blir 55
    */


    /*4*/
    public static int[] minmax(int[] a) {
        if (a.length < 1)
            throw new NoSuchElementException("Array must be of length 1 or greater");
        int min = 0, max = 0;

        for (int i = 1; i < a.length; i++) {
            if(a[i] > a[max]) max = i;
            if (a[i] < a[min]) min = i;
        }

        return new int[]{min, max};
    }
    /*
    HVOR MANGE SAMMENLIGNINGER?
    1, for å sjekke lengde større enn 1
        (((n = lengde på array)))
    n, antall ganger i sjekkes om er mindre enn a.length
    2x n-1, for max og for min
    * Antall: 1 + n + 2(n-1) = 1 + n + 2n -2 = 3n-1
    */

    public static long fak(int n) throws IOException {
        // Check if long value can hold the number and ensure that negative numbers can't return a factorial
        if(n > 25 | n < 0)
            throw new IOException("Input number must be a positive number, and can't exceed 25 as the method returns a long-value");

        // 0! should return 1
        if(n < 2) return 1;
        return n * fak(n-1);
    }

}
