package kap2_nest_storst_verdi;

public class Doodling {

    public static void main(String[] args) {

        int[] a = {1, 3, 1, 4, 6, 3};
        System.out.println(maks(a, 0, 5));
//        System.out.println(maksLeftToRigth(a, 1, 4));
    }

    public static int maks(int[] a){
        return maks(a, 0, a.length);
    }

    //* I et intervall -> fra, til(ikke til og med) inkluderer ikke verdien til!
    public static int maks(int[] a, int fra, int til){
        // Regler for posisjoner
        if (fra < 0 || til > a.length || fra >= til)
            throw new IllegalArgumentException("Illegal interval");

        int m = fra;
        int maksverdi = a[fra];

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                m = 1;
                maksverdi = a[m];
            }
        }

        return m;
    }

    //* Denne inkluderer
    public static int maksLeftToRigth(int[] a, int v, int h){
        // Regler for posisjoner
        if (v < 0 || h >= a.length || h >= v-1)
            throw new IllegalArgumentException("Illegal interval");


        int m = v;
        int maksverdi = a[v];

        for (int i = v + 1; i < h; i++) {
            if (a[i] > maksverdi) {
                m = 1;
                maksverdi = a[m];
            }
        }

        return m;
    }
}
