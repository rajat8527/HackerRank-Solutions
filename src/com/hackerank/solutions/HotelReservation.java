package com.hackerank.solutions;

import java.util.*;

public class HotelReservation {
    private static List<String> solution(){
        List<String> list1 = new ArrayList<>(Arrays.asList("1234 532632", "234 632633", "2354 732634"));
        List<String> list2 = new ArrayList<>(Arrays.asList("1234 532632", "234 632633", "458 642633", "2354 732634"));
        List<String> outputList = new ArrayList<>();

        list2.removeAll(list1);
        Map<Integer, String> map1 = new TreeMap<>();

        for(String s : list2){
            String[] splitString = s.split(" ");
            map1.put(Integer.parseInt(splitString[1]), splitString[0]);
        }

        map1.forEach((k,v) -> outputList.add(v));

        return outputList;
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }

}
