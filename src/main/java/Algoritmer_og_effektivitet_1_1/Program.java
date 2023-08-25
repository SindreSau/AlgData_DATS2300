package Algoritmer_og_effektivitet_1_1;

import java.util.Arrays;
import java.util.Random;

public class Program
{


    public static void main(String ... args)   // hovedprogram
    {
        long tid = 0;

        int n = 100_000;  // tabellstørrelse
        tid = System.currentTimeMillis(); // Leser av klokken
        antallMaks(randPerm(n));
        tid = System.currentTimeMillis() - tid; // Tid som har gått
        System.out.println("antallMaks brukte " + tid + " millisek på " + n);

        n = 100_000;  // tabellstørrelse
        tid = System.currentTimeMillis(); // Leser av klokken
        antallMaks(randPerm(n));
        tid = System.currentTimeMillis() - tid; // Tid som har gått
        System.out.println("antallMaks brukte " + tid + " millisek på " + n);

        //? HVORFOR BRUKER DEN 6ms første gang så 1-3ms andre gang med samme "n"?!
    }

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j]; a[j] = temp;
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    public static int antallMaks(int[] a)    // teller opp i a
    {
        int antall = 0;            // antall tall
        int maksverdi = a[0];

        for (int i = 1; i < a.length; i++)    // går gjennom tabellen a
        {
            if (a[i] > maksverdi)    // a[i] er større enn største foran
            {
                antall++;              // har funnet et nytt tall
                maksverdi = a[i];      // oppdaterer maksverdi
            }
        }

        return antall;    // de som er større enn det største foran
    }
}
