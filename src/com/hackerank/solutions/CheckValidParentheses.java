package com.hackerank.solutions;

public class CheckValidParentheses {
    private static void validateParentheses(int checkIfOpen, int checkIfClose, String str) {
        if (checkIfOpen == 0 && checkIfClose == 0){
            System.out.println(str);
        }
        if (checkIfOpen > checkIfClose){
            return;
        }
        if (checkIfOpen > 0){
            validateParentheses(checkIfOpen - 1, checkIfClose, str + "(");
        }
        if (checkIfClose > 0){
            validateParentheses(checkIfOpen, checkIfClose - 1, str + ")");
        }
    }

    private static void printValidArrangementsOfParantheses(int n) {
        validateParentheses(n, n, "");
    }

    public static void main(String[] args) {
        int n = 3;
        printValidArrangementsOfParantheses(n);
    }
}
