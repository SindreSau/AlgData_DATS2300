package div;

import java.util.Arrays;

public class SlidingWindow {
    static int[] subArraySum(int[] a, int subLength) {
        if (subLength < 2) {
            throw new IllegalArgumentException("subLength must be > 1");
        }

        int[] subSum = new int[a.length - subLength + 1];
        for (int i = 0; i < subSum.length; i++) {
            int sum = 0;
            if (i == 0) {
                for (int j = 0; j < subLength; j++) {
                    sum += a[j];
                }
            } else {
                sum = a[i + subLength - 1] + subSum[i - 1] - a[i - 1];
            }
            subSum[i] = sum;
        }
        return subSum;
    }
}

class Test {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8, 2, 9};
        // Sumarray should be [16, 16, 20]
        System.out.println(Arrays.toString(SlidingWindow.subArraySum(arr, 4)));
    }
}
