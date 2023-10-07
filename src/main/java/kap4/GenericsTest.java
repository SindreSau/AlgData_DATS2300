package kap4;

public class GenericsTest {
    public static void main(String[] args) {
        /*String[] a = {"Per", "Åge", "Thanh", "Fatima", "Kari", "Jasmin"};*/
        /*Integer[] a = {1, 8, 3, 5, 2, 7, 4, 6};*/
        /*Character[] a = {'A', 'C', 'E', 'B', 'D', 'F'};*/
        Double[] a = {1.0, 8.0, 3.0, 5.0, 2.0, 7.0, 4.0, 6.0};

        System.out.println(maks(a));
    }

    public static <T extends Comparable<? super T>> int maks(T[] a) {
        int m = 0;
        T maksVerdi = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(maksVerdi) > 0) {
                maksVerdi = a[i];
                m = i;
            }
        }

        return m;
    }
}
