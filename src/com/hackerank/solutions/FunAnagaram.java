package com.hackerank.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunAnagaram {

    private static List<String> funWithAnagrams(List<String> text) {
       String[] s = new String[text.size()];
        for(int i = 0; i < text.size(); i++){
            s[i] = text.get(i);
        }
        ArrayList<String> list1=new ArrayList<>();
        ArrayList<String> list2=new ArrayList<>();
        String x;
        for (String value : s) {
            char c[] = value.toCharArray();
            Arrays.sort(c);
            x = new String(c);
            if (!list1.contains(x)) {
                list2.add(value);
                list1.add(x);
            } else {
                continue;
            }
        }
        return list2;
    }

    public static void main(String[] args) {
        System.out.println(funWithAnagrams(Arrays.asList("code","aaagmnrs","anagrams","doce")));
    }
}
