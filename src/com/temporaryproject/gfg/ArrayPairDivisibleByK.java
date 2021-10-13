package com.temporaryproject.gfg;

public class ArrayPairDivisibleByK {

    /**
     * Find the number of pairs in the array whose difference is divisible by k
     *
     * @param arr
     * @param n   is the number of elements in the array
     * @param k   is the number to be divided by
     */
    static void countPairEfficient(int[] arr, int n, int k) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] + k) % k;
        }

        int[] hash = new int[k];

        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        for (int i = 0; i < k; i++) {
            cnt += (hash[i] * (hash[i] - 1)) / 2;
        }
        System.out.print(cnt + "\n");
    }

    /**
     * Find the number of pairs in the array whose difference is divisible by k
     *
     * @param arr
     * @param n   is the number of elements in the array
     * @param k   is the number to be divided by
     */
    static void countPairsUnoptimized(int[] arr, int n, int k) {

        // Initialize counters as zero.
        int i, j, cnt = 0;

        // Loop to count the valid pair
        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                if ((arr[i] - arr[j] + k) % k == 0)
                    cnt += 1;
            }
        }
        System.out.print(cnt + "\n");
    }

}
