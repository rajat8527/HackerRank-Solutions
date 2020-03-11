package com.hackerank.solutions;

public class MorganString {
    private static String morganAndString(String strA, String strB) {
        char[] arrA = strA.toCharArray();
        char[] arrB = strB.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        int length = arrA.length + arrB.length;

        for(int i = 0; i < length; i++){
            if(arrA[i] < arrB[i]){
                stringBuilder.append(arrA[i]);
            }else{
                stringBuilder.append(arrB[i]);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(morganAndString("JACK","DANIEL"));
    }
}
