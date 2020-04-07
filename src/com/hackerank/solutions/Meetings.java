package com.hackerank.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Meetings {
    public static int countMeetings(List<Integer> firstDay, List<Integer> lastDaty) {
        int count = 0;
        List<List<Integer>> notSameList = new ArrayList<>();
        int maxDepartureDate = Collections.max(lastDaty);

        List<Integer> weekdayList = new ArrayList<>();
        for(int i = 1; i <= maxDepartureDate; i++){
            weekdayList.add(i);
        }

        for(int i = 0; i < firstDay.size(); i++){
            List<Integer> list = new ArrayList<>();
            list.add(firstDay.get(i));
            list.add(lastDaty.get(i));
            if(firstDay.get(i).equals(lastDaty.get(i))){
                weekdayList.remove(firstDay.get(i));
                count++;
            }else{
                notSameList.add(Arrays.asList(firstDay.get(i), lastDaty.get(i)));
                for(int x : weekdayList){
                    for (List<Integer> integers : notSameList) {
                        if (integers.get(0).equals(x) && !integers.get(1).equals(x)) {
                                count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("count == "+countMeetings(Arrays.asList(1,1,2), Arrays.asList(1,2,2)));
    }

}
