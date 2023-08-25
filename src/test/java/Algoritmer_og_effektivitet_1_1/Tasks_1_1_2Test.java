package Algoritmer_og_effektivitet_1_1;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class Tasks_1_1_2Test {

    @Test
    void minShouldReturnException() {
        int[] empty = {};

        assertThrows(NoSuchElementException.class, () -> {
            Tasks_1_1_2.min(empty);
        });
    }

    @Test
    void minShouldReturnOne() {
        int[] a = {10, 2, 5};

        assertEquals(1, Tasks_1_1_2.min(a));
    }
}