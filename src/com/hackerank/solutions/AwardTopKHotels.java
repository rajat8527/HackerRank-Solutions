package com.hackerank.solutions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AwardTopKHotels {
    private static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
        String[] positveKeywordsList = positiveKeywords.split(" ");
        String[] negativeKeywordsList = negativeKeywords.split(" ");

        Map<Integer,StringBuilder> reviewMap = new HashMap<>();
        Map<Integer, Integer> hotelScoreMap = new HashMap<>();

        StringBuilder sb;
        for(int i = 0; i < hotelIds.size(); i++){
            int hotelId = hotelIds.get(i);
            if(reviewMap.containsKey(hotelId)){
                reviewMap.get(hotelId).append(reviews.get(i)).append(" ");
            }else {
                sb = new StringBuilder();
                sb.append(reviews.get(i)).append(" ");
                reviewMap.put(hotelId, sb);
            }
        }

        reviewMap.forEach((x,y) ->
                hotelScoreMap.put(x, sumKeywordScore(positveKeywordsList, negativeKeywordsList, y.toString()))
        );

        final Map<Integer, Integer> sortedByScore = hotelScoreMap.entrySet()
                .stream()
                .sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return new ArrayList<>(sortedByScore.keySet());
    }

    private static int sumKeywordScore(String[] positveKeywordsList, String[] negativeKeywordsList, String y){
        List<Integer> list = new ArrayList<>();
        for(String word : positveKeywordsList){
            int i = 0;
            Pattern p = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher( y );
            while (m.find()) {
                i++;
            }
            list.add(i*3);
        }
        for(String word : negativeKeywordsList){
            int i = 0;
            Pattern p = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher( y );
            while (m.find()) {
                i--;
            }
            list.add(i);
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {
        String a = "breakfast beach citycenter location metro view staff price";
        String b = "not";

        List<Integer> integerList = Arrays.asList(1,2,1,1,2);
        List<String> reviewsList = Arrays.asList("This hotel has a nice view of the citycenter. The location is perfect.",
                "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
                "Location is excellent, 5 minutes from citycenter.There is also a metro station very close to the hotel.",
                "They said I couldn't take my dog and there were other guests with dogs! That is not fair.",
                "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");
        int k = 2;
        System.out.println(awardTopKHotels(a,b,integerList,reviewsList,k));
    }
}
