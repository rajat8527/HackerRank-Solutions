package com.hackerank.solutions;

import java.util.*;

public class ArrangeWords {
    private static String arrangeWord(String sentence) {

        String[] splitString = sentence.split(" ");
        List<String> outputList = new ArrayList<>();
        Map<Integer, List<String>> map = new TreeMap<>();
        Set<Integer> set = new TreeSet<>();

        for(String s : splitString){
            set.add(s.length());
        }

        for (int s : set) {
            if(map.containsKey(s)){
                for (String value : splitString) {
                    if (value.length() == s) {
                        map.get(s).add(value);
                    }
                }
            }else {
                for (String value : splitString) {
                    if (value.length() == s) {
                        outputList.add(value);
                    }
                }
            }
            map.put(s, outputList);
            outputList = new ArrayList<>();
        }

        StringBuilder sb = new StringBuilder();

        map.forEach((k,v) -> sb.append(v).append(" "));

        String replaceSpecialCharacters = sb.toString().replaceAll("[^a-zA-Z0-9\\s]", "");

        String[] splitAgain = replaceSpecialCharacters.split(" ");
        splitAgain[0] = splitAgain[0].substring(0, 1).toUpperCase() + splitAgain[0].substring(1);

        for(int i = 1; i <= splitAgain.length-1; i++){
            splitAgain[i] = splitAgain[i].toLowerCase();
        }

        StringBuilder sb1 = new StringBuilder();

        for(String s : splitAgain){
            sb1.append(s).append(" ");
        }

        String s3 = sb1.toString();
        String s4 = s3.trim();

        return s4+".";
    }

    public static void main(String[] args) {
        System.out.println(arrangeWord("Also notice that preprocessor statements which is highlighted appear at the start of the program these statements cause the contents of the header file stdio and ctype to inserted into the program the compilation process begins the information contains in these files is essential for the proper functioning of the library functions getchar putchar and toupper."));
    }
}
