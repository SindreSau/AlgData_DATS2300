package Sedgewick_and_Wayne_book.Chapter_1;

public class Tasks {

    public static void main(String[] args) {

        /*1.1.24*/
        /*gcd(1111111, 1234567);*/


    }

    /**Task 1.1.24*/
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        System.out.println("p: " + p + ", q: " + q);
        return gcd(q, r);
    }
}
