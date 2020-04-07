package com.hackerank.solutions;

import java.util.*;

public class CrashingStones {
    public static int lastStoneWeight(List<Integer> weights) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(weights);
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if (a != b) pq.offer(Math.abs(a - b));
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(Arrays.asList(1,2,3,6,7,7)));
    }
}
