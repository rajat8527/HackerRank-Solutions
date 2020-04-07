package com.hackerank.solutions;

public class WaysToFindSum {
    private static int countWays(int[] arr, int N){

        int countArr[] = new int[N+1];

        countArr[0] = 1;

        for(int i = 1; i <= N; i++){
            for (int value : arr) {
                if (i >= value) {
                    countArr[i] += countArr[i - value];
                }
            }
        }

        return countArr[N];
    }

    public static void main(String[] args) {
        System.out.println(countWays(new int[]{2,3,6,5}, 10));
    }
}
