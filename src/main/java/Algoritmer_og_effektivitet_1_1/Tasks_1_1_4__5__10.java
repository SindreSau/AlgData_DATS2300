package Algoritmer_og_effektivitet_1_1;

public class Tasks_1_1_4__5__10 {

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 5, 3};
//        System.out.println(maksGuarded(a));
//        System.out.println(maksGuarded2(a));
        System.out.println(maksGuarded3(a));
    }


    //! 1.1.4
    // Optimalisert maks() fra 1.1.4
    public static int maks(int[] a)   // versjon 2 av maks-metoden
    {
        int m = 0;               // indeks til største verdi
        int maksverdi = a[0];    // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdateres
        }
        return m;   // returnerer indeks/posisjonen til største verdi

    } // maks

    /*
    Optimalisering:
    - Det er raskere å lage en hjelpevariabel for a[n] enn å aksessere a[n] flere ganger i en forloop
    - i 1.1.2 blir hvert element sammenlignet med arrayelementer. if(a[i] > a[n])!
        - a[i] > variabelNavn er raskere enn a[i] > a[n]
    */

    /*
    1, sette verdi av variabel m
    2, hente verdi av a[0] og sette variabel til denne verdien
    1, sette verdi av i lik 1
    n, sjekk om i < a.length
    2(n-1), hente verdi a[i] og sammenligne med maksverdi
    x * 3, hente ut a[i] og sette to variabler hvis 2(n-1) over er sann
    1, returnere m
    Gir: 3 + 3n + x(3)

    {10, 5, 7, 2, 9, 1, 3, 8, 4, 6}:
    n = 10
    x = 0
    SUM = 30 + 3 = 33

    {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}:
    n = 10
    x = 9
    SUM = 30 + 27 + 3 = 60

    {1, 3, 2, 7, 5, 9, 6, 8, 10, 4}
    n = 10
    x = 4
    SUM = 30 + 12 + 3  = 45
    */


    //! 1.1.5
    public static int maksGuarded(int[] a)  // versjon 3 av maks-metoden
    {
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    } // maks

    /*
    *1

    {1, 3, 2}
    sist = 2
    maksverdi = 1
    temp = 2
    a[sist](2) = vakt

    runde "0"
    i = 0
    a[0] = 1
    1 er lik maksverdi, kjør block
    i != 2!
    else block -> maksverdi settes lik 1, m = 0
    i++

    runde "1"
    i = 1
    3 > 1 men i != 2, kjør else
    maksverdi settes lik 3, m settes til 1
    i++

    runde "2"
    i = 2
    vakt er større enn 3, kjør blokk
    i er lik sist, kjør if-blokk
    siste verdi(2) settes tilbake fra temp til a[2]
    2 er ikke størreEllerLik maksverdi(3), så vi returnerer m(1)
    RETURNERER 1!

    ?Hvis lengden er 0, arrayet tomt, vil man få en Index 0 out og bounds for length 0


    *2
    */
    public static int maksGuarded2(int[] a)  // versjon 3 av maks-metoden
    {
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] > maksverdi)       //! Endret til > fra >=
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    } // maks

    /*
    *3
    {1, 3, 2}
    */
    public static int maksGuarded3(int[] a)  // versjon 3 av maks-metoden
    {
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        /*a[sist] = maksverdi;*/          //! Denne legges heller i else-setningen!

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    a[sist] = maksverdi;            //! Flyttet hit fra toppen
                    System.out.println(a[sist]);
                    m = i;                   // m oppdateres
                }
            }
    } // maks


}
