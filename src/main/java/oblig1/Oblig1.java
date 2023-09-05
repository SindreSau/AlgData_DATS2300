package oblig1;

import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 2, 9, 12, 2, 1};

        System.out.println(maks(a));
    }

    public static int maks(int[] a) {
        if (a.length < 1)
            throw new NoSuchElementException("Arrayet kan ikke være tomt!");

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                bytt(a, i, i-1);
            }
        }

        return a[a.length - 1];
    }

    public static void bytt(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int ombyttinger(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 2
    public static int antallUlikeSortert(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 3
    public static int antallUlikeUsortert(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 4
    public static void delsortering(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 5
    public static void rotasjon(char[] a) {throw new UnsupportedOperationException();}

    // Oppgave 6
    public static void rotasjon(char[] a, int k) {throw new UnsupportedOperationException();}

    // Oppgave 7
    public static String flett(String s, String t) {throw new UnsupportedOperationException();}

    public static String flett(String... s) {throw new UnsupportedOperationException();}

    // Oppgave 8
    public static int[] indeksSortering(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 9
    public static int[] tredjeMin(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 10
    public static boolean inneholdt(String a, String b) {throw new UnsupportedOperationException();}
}
