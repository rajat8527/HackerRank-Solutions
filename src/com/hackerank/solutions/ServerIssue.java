package com.hackerank.solutions;

import java.util.*;

public class ServerIssue {
    private static void checkServerLoadIssue(String log){
        String[] splitLog = log.split("\n");
        int timeT = Integer.parseInt(splitLog[0]);
        List<String> logList = new ArrayList<>(Arrays.asList(splitLog).subList(1, splitLog.length));

        Map<String, List<Integer>> processTimeMap = new TreeMap<>();
        Map<String, List<String>> processStateMap = new TreeMap<>();
        List<Integer> timeList;
        List<String> stateList;

        for(String str : logList){
            String[] splitEachLog = str.split(" ");
            if(processTimeMap.containsKey(splitEachLog[1])){
                processTimeMap.get(splitEachLog[1]).add(Integer.parseInt(splitEachLog[0]));
                processStateMap.get(splitEachLog[1]).add(splitEachLog[2]);
            }else{
                timeList = new ArrayList<>();
                stateList = new ArrayList<>();
                timeList.add(Integer.parseInt(splitEachLog[0]));
                stateList.add(splitEachLog[2]);
                processTimeMap.put(splitEachLog[1], timeList);
                processStateMap.put(splitEachLog[1], stateList);
            }
        }

        Map<String,String> finalMap = new TreeMap<>();

        processTimeMap.forEach((k,v) -> {
            String state = "";
            for(int i = 0; i < v.size(); i++){
                if(v.get(i) <= timeT && processStateMap.containsKey(k)){
                    state = processStateMap.get(k).get(i);
                }
            }
            finalMap.put(k, state);
        });

        List<String> outputList = new ArrayList<>();

        finalMap.forEach((k,v) -> {
            if(v.equalsIgnoreCase("running")){
                outputList.add(k);
            }
        });

        if(outputList.size() == 1){
            System.out.println(outputList.get(0));
        }else{
            System.out.println("-1");
        }
    }

    public static void main(String[] args) {
        checkServerLoadIssue("41\n" +
                "0 A created\n" +
                "1 B created\n" +
                "5 A running\n" +
                "7 B waiting\n" +
                "8 B running\n" +
                "9 A waiting\n" +
                "11 B terminated\n" +
                "12 A terminated\n" +
                "15 C created\n" +
                "16 D created\n" +
                "18 C running\n" +
                "20 D waiting\n" +
                "22 D running\n" +
                "23 C waiting\n" +
                "24 D terminated\n" +
                "27 C terminated\n" +
                "30 E created\n" +
                "32 E running\n" +
                "34 A created\n" +
                "36 A running\n" +
                "37 A waiting\n" +
                "39 F created\n" +
                "40 H created\n" +
                "42 G created\n" +
                "45 F running\n" +
                "46 H running\n" +
                "48 G running\n" +
                "50 A terminated\n" +
                "53 G waiting\n" +
                "55 H waiting\n" +
                "57 H terminated\n" +
                "58 G terminated\n" +
                "60 F terminated\n" +
                "74 E terminated");
    }
}
