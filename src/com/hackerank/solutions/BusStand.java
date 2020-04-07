package com.hackerank.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BusStand {
    public static List<Integer> kthPerson(int k, List<Integer> p, List<Integer> q) {
        List<Integer> outputList = new ArrayList<>();
        List<Integer> tempList;
        for(int i : q){
            tempList = new ArrayList<>();
            for(int j : p){
                if(j >= i){
                    tempList.add(j);
                }
            }

            if(tempList.isEmpty()|| tempList.size() == 1){
                for(int z = 0; z < k; z++){
                    tempList.add(0);
                }
            }

            //Collections.sort(tempList);
            //System.out.println(tempList);

            List<Integer> listWithoutDuplicates = tempList.stream()
                    .distinct()
                    .collect(Collectors.toList());

            //Collections.sort(listWithoutDuplicates);

            //System.out.println(listWithoutDuplicates);
            //System.out.println("==");
            outputList.add(listWithoutDuplicates.get(k-2));
        }
        return outputList;
    }

    public static void main(String[] args) {
        System.out.println(kthPerson(2, Arrays.asList(1,2,3,4), Arrays.asList(1,3,4)));
    }
}
