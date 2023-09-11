package oblig1;

import utils.Randperm;
import java.util.*;

import static java.util.Objects.isNull;

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
        /*int[] a = {6, 10, 9, 4, 1, 3, 8, 5, 2, 7};
        System.out.println(Arrays.toString(a));
        delsortering(a);
        System.out.println(Arrays.toString(a));*/

        // For testing av oppg 5 og 6
        /*char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        *//*rotasjon(a);*//*
        *//*rotasjon(a, 3);*//*
        rotasjon(a,  -2);
        System.out.println(Arrays.toString(a));*/

        // For testing av oppg 7
        String s = "AB";
        String t = "DE";
        /*System.out.println(flett(s, t));*/
        String f = null;
        System.out.println(flett(s, f, t));
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
        int i = 0, j = a.length - 1;
        while (i <= j) {
            if (a[i] % 2 == 0) { // Partall, vi bytter med høyre posisjon
                bytt(a, i, j);
                j--;
            }
            else { // Oddetall, inkrementer i
                i++;
            }
        }

        // J er nå posisjon til siste oddeTall
        Arrays.sort(a, 0, j + 1);       // Sorter oddetall
        Arrays.sort(a, j + 1, a.length); // Sorter partall
    }

    // Oppgave 5
    public static void rotasjon(char[] a) {

        // Lagre siste element
        char siste = a[a.length - 1];


        for (int i = a.length - 2; i >= 0; i--) {
            a[i + 1] = a[i];
        }

        a[0] = siste;
    }

    // Oppgave 6
    public static void rotasjon(char[] a, int k) {
        if (a.length < 1)
            return;

        /*
        Hvis k er negativt, vil vi rotere motsatt vei.
        Vi kan da se på det som at vi roterer k elementer til høyre.
        Eks: k = -2 & a.length = 5 => k = 3
          1. Lag midlertidig array med de 3 siste elementene
          2. Flytt de to første elementene til høyre
          3. Legg til elementene fra midlertidig array

        Hvis k er større enn lengden på arrayet, vil vi rotere k % a.length ganger.
        */
        k %= a.length;
        if (k < 0)
            k = k += a.length; // Gjør k positivt

        System.out.println(k);

        char[] b = Arrays.copyOfRange(a, a.length - k, a.length);

        System.out.println(Arrays.toString(b));

        // Flytt elementer til høyre
        for (int i = a.length - 1; i >= k; i--) {
            a[i] = a[i - k];
        }

        // Legg til elementer fra b
        System.arraycopy(b, 0, a, 0, k);
    }

    // Oppgave 7
    public static String flett(String s, String t) {
        // Hvis s eller t er null, returner ""
        if (isNull(s) || isNull(t))
            return "";

        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;
        // Legg til elementer fra s og t til enten i eller j er lik lengden på en av strengene
        while (i < s.length() && j < t.length()) {
            sb.append(s.charAt(i++));
            sb.append(t.charAt(j++));
        }

        // Legg til resterende elementer
        while (i < s.length()) {
            sb.append(s.charAt(i++));
        }

        // Legg til resterende elementer
        while (j < t.length()) {
            sb.append(t.charAt(j++));
        }

        return sb.toString();
    }

    public static String flett(String... s) {
        // Hvis s er null eller s[i] er null for en i, returner ""
        if (isNull(s))
            return "";
        for (String str : s) {
            if (isNull(str))
                return "";
        }

        StringBuilder sb = new StringBuilder();

        int j = 0;
        while (j < s.length) {
            for (String str : s) {
                if (j < str.length())
                    sb.append(str.charAt(j));
            }
            j++;
        }

        return sb.toString();
    }


    // Oppgave 8
    public static int[] indeksSortering(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 9
    public static int[] tredjeMin(int[] a) {throw new UnsupportedOperationException();}

    // Oppgave 10
    public static boolean inneholdt(String a, String b) {throw new UnsupportedOperationException();}
}
