package com.hackerank.solutions;

import java.util.Arrays;
import java.util.List;

public class RearrangeElementsToFromLargestNumber {

    private static void findLargest(int[] arr){
        String[] strArr = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        List<String> list = Arrays.asList(strArr);

        list.sort((a, b) -> (b + a).compareTo(a + b));

        list.forEach(
                System.out::print
        );
    }

    public static void main(String[] args) {
        findLargest(new int[]{2, 9, 98, 555, 59, 52, 967});
    }
}
