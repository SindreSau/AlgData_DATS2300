package Algoritmer_og_effektivitet_1_1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class Tasks_1_1_3Test {

    @Test
    void minmaxReturnsTwoAndFour() {
        int[] a = {5, 4, 1, 6,10};
        int[] shouldEqual = {2, 4};
        assertArrayEquals(shouldEqual, Tasks_1_1_3.minmax(a));
    }

    @Test
    void minmaxThrowsException() {
        int[] empty = {};

        assertThrows(NoSuchElementException.class, () -> {
            Tasks_1_1_3.minmax(empty);
        });
    }

    @Test
    void fakReturnsSix() throws IOException {
        assertEquals(6, Tasks_1_1_3.fak(3));
    }

    @Test
    void fakReturns40320() throws IOException {
        assertEquals(40320, Tasks_1_1_3.fak(8));

    }

    @Test
    void fakThrowsIOException() {
        int n = -1;
        assertThrows(IOException.class, () -> {
            Tasks_1_1_3.fak(n);
        });
    }
}