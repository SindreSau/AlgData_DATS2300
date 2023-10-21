package oblig2;

import java.util.*;

public class DobbeltLenketListe<T> implements Liste<T> {
    // Innebygd (Trenger ikke endres)

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;
        private Node<T> forrige, neste;

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi; this.forrige = forrige; this.neste = neste;
        }
        private Node(T verdi) {this(verdi, null, null);}
    }

    private Node<T> hode;
    private Node<T> hale;
    private int antall;
    private int endringer;

    public void fraTilKontroll(int fra, int til) {
        if (fra < 0) throw new IndexOutOfBoundsException("fra("+fra+") er negativ.");
        if (til > antall) throw new IndexOutOfBoundsException("til("+til+") er større enn antall("+antall+")");
        if (fra > til) throw new IllegalArgumentException("fra("+fra+") er større enn til("+til+") - Ulovlig intervall.");
    }

    // Oppgave 0
    public static int gruppeMedlemmer() {
        return (int) Math.PI; // Returner hvor mange som er i gruppa deres
    }

    // Oppgave 1
    public DobbeltLenketListe() {
        hode = null;
        hale = null;
    }

    public DobbeltLenketListe(T[] a) {
        Objects.requireNonNull(a, "a kan ikke være en null-peker");

        Node<T> n;
        for (T t : a) {
            // Hopp over hvis verdi er null
            if (t == null) continue;

            n = new Node<>(t);
            if (hode == null) { // Vi vet at dette er første element
                hode = n;
            } else {
                n.forrige = hale;
                hale.neste = n;
            }
            hale = n;
            antall++;
        }
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    // Oppgave 2
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (antall < 1) return "[]";

        sb.append("[");
        Node<T> midlertidig = hode;
        while (midlertidig != null) {
            sb.append(midlertidig.verdi);
            if (midlertidig.neste != null) sb.append(", ");
            midlertidig = midlertidig.neste;
        }
        sb.append("]");
        return sb.toString();
    }

    public String omvendtString() {
        StringBuilder sb = new StringBuilder();
        if (antall < 1) return "[]";

        sb.append("[");
        Node<T> midlertidig = this.hale;
        while (midlertidig != null) {
            sb.append(midlertidig.verdi);
            if (midlertidig.forrige != null) sb.append(", ");
            midlertidig = midlertidig.forrige;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean leggInn(T verdi) {
        if (verdi == null) throw new NullPointerException("Verdi kan ikke være null");

        Node<T> node = new Node<>(verdi);
        if (hode == null) {
            hode = node;
        } else {
            node.forrige = hale;
            hale.neste = node;
        }
        hale = node;
        antall++;
        endringer++;
        return true;
    }

    // Oppgave 3
    private Node<T> finnNode(int indeks) {
        // Returner hode eller hale om indeks er 0 eller antall-1
        if (indeks == 0) return hode;
        int ovreIndeks = antall - 1;
        if (indeks == ovreIndeks) return hale;

        // Returner node fra hode eller hale avhengig av indeks-verdi
        Node<T> retur;
        if (indeks < antall / 2) {
            retur = hode.neste;
            for (int i = 1; i < indeks; i++) {
                retur = retur.neste;
            }
        } else {
            retur = hale.forrige;
            ovreIndeks -= 1;
            for (int i = ovreIndeks; i > indeks; i--) {
                retur = retur.forrige;
            }
        }
        return retur;
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        indeksKontroll(indeks, false);
        if (nyverdi == null) throw new NullPointerException("Det må legges inn en ny verdi");

        Node<T> n = finnNode(indeks);
        T retVerdi = n.verdi;

        n.verdi = nyverdi;
        endringer++;
        return retVerdi;
    }


    public Liste<T> subliste(int fra, int til) {
        fraTilKontroll(fra, til);
        DobbeltLenketListe<T> subListe = new DobbeltLenketListe<>();
        for (int i = fra; i < til; i++) {
            subListe.leggInn(hent(i));
        }
        return subListe;
    }

    // Oppgave 4
    @Override
    public int indeksTil(T verdi) {
        for (int i = 0; i < antall; i++) {
            if (verdi.equals(hent(i))) return i;
        }

        return -1;
    }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    // Oppgave 5
    @Override
    public void leggInn(int indeks, T verdi) {
        indeksKontroll(indeks, true);
        if (verdi == null) throw new NullPointerException("Verdi kan ikke være null");

        if (tom() || indeks == this.antall) {
            leggInn(verdi);
        } else {
            Node<T> indeksNode = finnNode(indeks);
            Node<T> nyNode;
            // Sette inn foran hvis indeks = 0
            if (indeks < 1) {
                nyNode = new Node<>(verdi, null, indeksNode);
                hode = nyNode;
            } else {
                nyNode = new Node<>(verdi, indeksNode.forrige, indeksNode);
                indeksNode.forrige.neste = nyNode;
            }
            indeksNode.forrige = nyNode;

            antall++;
            endringer++;
        }
    }

    // Oppgave 6
    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks, false);

        Node<T> fjernes = finnNode(indeks);
        T returVerdi = fjernes.verdi;

        if (indeks == 0) {
            hode = fjernes.neste;
            fjernes.neste = null;
            if (antall > 1) hode.forrige = null;
        } else if (indeks == antall - 1) {
            hale = fjernes.forrige;
            fjernes.forrige = null;
            hale.neste = null;
        } else {
            fjernes.forrige.neste = fjernes.neste;
            fjernes.neste.forrige = fjernes.forrige;
            fjernes.neste = null;
            fjernes.forrige = null;
        }

        antall--;
        endringer++;
        return returVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        if (verdi == null) {
            return false;
        }

        Node<T> n = hode;
        // Sjekk hode
        if (verdi.equals(hode.verdi)) {
            hode = n.neste;
            n.neste = null;
            antall--;
            endringer++;
            return true;
        }
        // Sjekk midten
        for (int i = 1; i < antall - 1; i++) {
            n = n.neste;
            if (verdi.equals(n.verdi)) {
                n.forrige.neste = n.neste;
                n.neste.forrige = n.forrige;
                n.neste = null;
                n.forrige = null;

                antall--;
                endringer++;
                return true;
            }
        }
        // Sjekk hale
        if (verdi.equals(hale.verdi)) {
            hale = n.forrige;
            hale.neste = null;
            n.forrige = null;
            antall--;
            endringer++;
            return true;
        }

        return false;
    }

    // Oppgave 7
    /**
     * Versjon a)
     * Bruker: 5ms på 1_000_000 elementer
     * */
    @Override
    public void nullstill() {
        long testTid = System.currentTimeMillis();

        Node<T> n = hode;
        while (n != null) {
            Node<T> neste = n.neste;
            n.verdi = null;
            n.neste = null;
            n.forrige = null;
            n = neste;
        }
        hode = null;
        hale = null;
        antall = 0;
        endringer++;

        testTid = System.currentTimeMillis() - testTid;
        // System.out.println("Tid: " + testTid + "ms");
    }

    /**
     * Versjon a)
     * Bruker: 8ms på 1_000_000 elementer
     * */
    /*@Override
    public void nullstill() {
        long testTid = System.currentTimeMillis();

        // Bruk fjern() for å fjerne elementer
        for (int i = antall - 1; i >= 0; i--) {
            fjern(i);
        }

        testTid = System.currentTimeMillis() - testTid;
        System.out.println("Tid: " + testTid + "ms");
    }*/

    // Oppgave 8
    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean kanFjerne;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;                   // Starter på første i lista
            kanFjerne = false;              // Settes true når next() kalles
            iteratorendringer = endringer;  // Teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            denne = finnNode(indeks);       // Starter på indeks
            kanFjerne = false;              // Settes true når next() kalles
            iteratorendringer = endringer;  // Teller endringer
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            if (iteratorendringer != endringer) throw new ConcurrentModificationException("Listen har blitt endret");
            if (!hasNext()) throw new NoSuchElementException("Ingen flere elementer");

            kanFjerne = true;
            T verdi = denne.verdi;
            denne = denne.neste;
            return verdi;
        }

        // Oppgave 9:
        @Override
        public void remove() {
            if (!kanFjerne) throw new IllegalStateException("Kan ikke fjerne elementet");
            if (iteratorendringer != endringer) throw new ConcurrentModificationException("Listen har blitt endret");

            kanFjerne = false;

            if (antall == 1) { // ett element
                hode = null;
                hale = null;
            } else if (denne == null) { // siste element
                hale = hale.forrige;
                hale.neste = null;
            } else if (denne.forrige == hode) { // første element
                hode = denne;
                hode.forrige = null;
            } else {
                denne.forrige.forrige.neste = denne;
                denne.forrige = denne.forrige.forrige;
            }

            antall--;
            endringer++;
            iteratorendringer++;
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks, false);
        return new DobbeltLenketListeIterator(indeks);
    }

    // Oppgave 10
    // Bubble sort O(n^2)
    // Bruker 1 sekund på ca. 1400 elementer og 8 sekund på ca. 2800 elementer
    /*public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        long testTid = System.currentTimeMillis();

        // Sjekk om listen er tom
        if (liste.antall() < 1) return;

        // Sorter listen
        for (int i = 0; i < liste.antall() - 1; i++) {
            for (int j = 0; j < liste.antall() - i - 1; j++) {
                T verdi1 = liste.hent(j);
                T verdi2 = liste.hent(j + 1);
                if (c.compare(verdi1, verdi2) > 0) {
                    liste.oppdater(j, verdi2);
                    liste.oppdater(j + 1, verdi1);
                }
            }
        }

        testTid = System.currentTimeMillis() - testTid;
        System.out.println("Tid: " + testTid + "ms");
    }*/

    // Insertion sort O(n^2) i worst case, O(n) i best case
    // Bruker 1 sekund på ca. 1400 elementer og 8 sekund på ca. 2800 elementer hvis elementer er tilfeldig
    // Hvis listen allerede er sortert
    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        long testTid = System.currentTimeMillis();

        // Sjekk om listen er tom
        if (liste.antall() < 1) return;

        // Sorter listen
        for (int i = 1; i < liste.antall(); i++) {
            T key = liste.hent(i);
            int j = i - 1;

            // Flytt elementer som er større enn key, en posisjon frem
            while (j >= 0 && c.compare(liste.hent(j), key) > 0) {
                liste.oppdater(j + 1, liste.hent(j));
                j = j - 1;
            }
            liste.oppdater(j + 1, key);
        }

        testTid = System.currentTimeMillis() - testTid;
        System.out.println("Tid: " + testTid + "ms");
    }
}

class Test {
    public static void main(String[] args) {

    }
}