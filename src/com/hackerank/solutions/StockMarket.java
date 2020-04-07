package com.hackerank.solutions;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class StockMarket {
    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
        Map<Integer, Integer> stockMap = new HashMap<>();
        List<Integer> outputList = new ArrayList<>();


        for(int i = 0; i < stockData.size(); i++){
            stockMap.put(i+1, stockData.get(i));
        }

        queries.forEach( x -> {
            Map<Integer, Integer> map1 = new HashMap<>();
            int z = stockMap.get(x);

            stockMap.forEach((k,v) -> {
                if (v < z) {
                    map1.put(k,Math.abs(k-x));
                }
            });

            List<Integer> list = new ArrayList<>(map1.values());

            if(list.isEmpty()){
                outputList.add(-1);
            }else{
                Collections.sort(list);
                int min = list.get(0);
                List<Integer> keysList = map1.entrySet().stream()
                        .filter(e -> e.getValue().equals(min))
                        .map(Map.Entry::getKey).sorted().collect(toList());
                outputList.add(keysList.get(0));
            }
        });

        return outputList;
    }

    public static void main(String[] args) {
        System.out.println(predictAnswer(Arrays.asList(5,6,8,4,9,10,8,3,6,4), Arrays.asList(3,1,8)));
    }
}
