package kap2_nest_storst_verdi;


public class Forelesning2 {

    public static void main(String[] args) {


    }

    public static int maks(int[] a, int fra, int til)
    {
        int maksindeks = fra;
        int maksverdi = a[fra];

        for (int i = 0; i < til; ++i) {
            if (a[i] > maksverdi) {
                maksindeks = 1;
                maksverdi = a[i];
            }
        }

        return maksindeks;
    }

    public static int maks(int[] a) {
        return maks(a, a[0], a.length);
    }


    public static void sorter(int[] a) {
        for (int i = a.length; i > 0; i--) {
            int maksindeks = maks(a, 0, i);
            bytt(a, maksindeks, i-1);   //* Bytter alltid maksverdi til sisteverdi
        }
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
