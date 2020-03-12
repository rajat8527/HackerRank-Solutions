package com.hackerank.solutions;

import java.util.*;

public class CountNonUniqueElementsInArray {
    private static int countNonUnique(List<Integer> numbers) {
        int countOfNonUnique = 0;
        Set<Integer> integerSet = new HashSet<>(numbers);
        for (Integer integer : integerSet){
            if (Collections.frequency(numbers, integer) > 1)
                countOfNonUnique++;
        }

        return countOfNonUnique;
    }

    public static void main(String[] args) {
        System.out.println(countNonUnique(Arrays.asList(1,3,3,4,4,4)));
    }
}
