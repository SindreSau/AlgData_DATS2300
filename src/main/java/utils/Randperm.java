package utils;

import java.util.Random;

public class Randperm {
    public static int[] getRandomArray(int size, int lowestPossibleNumber, int higestPossibleNumber) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(Math.abs(higestPossibleNumber - lowestPossibleNumber + 1)) + lowestPossibleNumber;
        }
        return array;
    }
}
