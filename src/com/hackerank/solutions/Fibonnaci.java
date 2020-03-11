package com.hackerank.solutions;

import java.util.ArrayList;
import java.util.List;

public class Fibonnaci {
    private static List<Integer> fibonacci(int n) {
        List<Integer> list = new ArrayList<>();
        int a = 0, b = 0, c = 1;
        for(int i = 1; i <= n; i++)
        {
            a = b;
            b = c;
            c = a + b;
            list.add(a);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(4));
    }
}
