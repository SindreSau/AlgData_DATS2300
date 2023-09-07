package oblig1;

import utils.Randperm;

import java.util.*;

import static java.lang.Math.round;

public class Oblig1 {
    private Oblig1() {}

    public static void main(String[] args) {
        // For kjøring og testing av oppg 1
        /*int[] a = {3, 1, 2, 4};
        int[] rand = Randperm.getRandomArray(0, 0, 10);
        //System.out.println(Arrays.toString(rand));

        System.out.println(ombyttinger(a));
        printSnitt(10, 10000);*/

        //For kjøring og testing av oppg 2 og 3
        /*int[] a = {3, 3, 4, 5, 5, 6, 7, 7, 7, 8};
        int[] b = {10, 2, 3, 5, 2, 8, 3, 10};
        System.out.println(antallUlikeSortert(a));
        System.out.println(antallUlikeUsortert(b));*/

        // For kjøring og testing av oppg 4
        int[] a = {6, 10, 9, 4, 1, 3, 8, 5, 2, 7};
        System.out.println(Arrays.toString(a));
        delsortering(a);
        System.out.println(Arrays.toString(a));
    }


    /*Bare for testing*/
    private static void printSnitt(int size, int weigth) {
        int sum = 0;
        for (int i = 0; i < weigth; i++) {
            sum += ombyttinger(Randperm.getRandomArray(size, 0, 10));
        }
        double snitt = (double) sum / weigth;
        System.out.printf("Snittet er: %.1f", snitt);
    }

    public static int maks(int[] a) {
        if (a.length < 1)
            throw new NoSuchElementException("Arrayet kan ikke være tomt!");

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i])
                bytt(a, i, i-1);
        }

        return a[a.length - 1]; // Største verdi vil nå ligge sist, og derfor returneres
    }
    /*
    a)
        Antall sammenlikniger:
        1 : a.length < 1
        n - 1 : i < a.length
        n - 1 : if-statement i for-loop
        SUM = 2(n-1) + 1 = 2n-1
    b)
        Dersom arrayet er sortert stigende vil det bli 0 ombyttinger
    c)
        Dersom arrayet er sortert synkende vil det bli n-1 ombyttinger
    d)
        Gjennomsnittet av disse vil da bli:
            ((n-1) - 0) / 2
            = (n-1) / 2
        !STEMMER IKKE OVERENS MED RESULTATET I OMBYTTINGER-METODEN
    */

    private static void bytt(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int ombyttinger(int[] a) {
        if (a.length < 1)
            throw new NoSuchElementException("Arrayet kan ikke være tomt!");

        int ombyttinger = 0; // Antar at vi mener ett bytt som hele bytteoperasjonen (3 steg)

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                bytt(a, i, i-1);
                ombyttinger++;
            }
        }

        return ombyttinger;
    }

    // Oppgave 2
    public static int antallUlikeSortert(int[] a) {
        if (!erSortert(a))
            throw new IllegalStateException("Arrayet må være sortert stigende");

        if (a.length < 1)
            return 0;

        // Siden et map kun lagrer unike verdier som nøkler vil den bare lagre hvert unike element
        Map<Integer, Integer> unikeVerdier = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            unikeVerdier.put(a[i], i);
        }

        return unikeVerdier.size();
    }

    public static boolean erSortert(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1])
                return false;
        }
        return true;
    }

    // Oppgave 3
    public static int antallUlikeUsortert(int[] a) {
        if (a.length < 1)
            return 0;

        // Siden et map kun lagrer unike verdier som nøkler vil den bare lagre hvert unike element
        Map<Integer, Integer> unikeVerdier = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            unikeVerdier.put(a[i], i);
        }

        return unikeVerdier.size();
    }

    // Oppgave 4
    public static void delsortering(int[] a) {
        if (a.length < 1)
            return;

        // Partisjonering: oddetall | partall
        int i = 0;
        int j = a.length - 1;
        int oddeTall = 0;
        while (i < j) {
            while (a[i] % 2 != 0 && i < j) {
                i++;
                oddeTall++;
            }
            while (a[j] % 2 == 0 && i < j) {
                j--;
            }
            bytt(a, i, j);
        }

        // Sortering av hver partisjon med bubblesort
        bubbleSort(a, 0, oddeTall);
        bubbleSort(a, oddeTall, a.length);
    }

    // Mulig denne burde forbedres så indre for-loop krymper for hver i++
    private static void bubbleSort(int[] a, int fraIndeks, int tilIndeks) {
        for (int i = fraIndeks; i < tilIndeks; i++) {
            for (int j = fraIndeks; j < tilIndeks - 1; j++) {
                if (a[j] > a[j + 1])
                    bytt(a, j, j + 1);
            }
        }
    }

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
