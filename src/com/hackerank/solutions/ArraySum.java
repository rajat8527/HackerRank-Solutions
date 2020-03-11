package com.hackerank.solutions;

import java.util.Collections;
import java.util.List;

public class ArraySum {
    public static int minSum(List<Integer> num, int k) {

        Collections.sort(num);
        for (int i = 0; i < k; i++) {
            int len = num.size();
            if (num.get(len-1) % 2 == 0) {
                num.set(len-1, num.get(len-1)/2);
            } else {
                num.set(len-1,(int) Math.ceil((double) num.get(len-1) / 2));
            }
            Collections.sort(num);
        }

        return num.stream().mapToInt(Integer::intValue).sum();

    }
}
