package com.hackerank.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramDifference {
    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        // Write your code here
        List<Integer> outputList = new ArrayList<>();
        for(int i = 0; i < a.size(); i++){
            if(a.get(i).length() != b.get(i).length()){
                outputList.add(-1);
            }else{
                outputList.add(getDifference(a.get(i), b.get(i)));
            }
        }
        return outputList;
    }

    private static int getDifference(String s1, String s2){
        int[] arr = new int['z' + 1];
        for (char c : s1.toCharArray()) {
            arr[c]++;
        }
        for (char c : s2.toCharArray()) {
            arr[c]--;
        }
        int result = 0;
        for (int i = 0; i <= 'z'; i++) {
            result += Math.abs(arr[i]);
        }
        return result / 2;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumDifference(Arrays.asList("tea","tea","act"), Arrays.asList("ate","toe","acts")));
    }

}
