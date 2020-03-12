package com.hackerank.solutions;

public class PerfectSubstring {
    private static int MAX_CHAR = 26;
    private static boolean check(int[] frequencyArray, int k)
    {
        for (int i = 0; i < MAX_CHAR; i++)
            if (frequencyArray[i] !=0 && frequencyArray[i] != k)
                return false;
        return true;
    }

    private static int perfectSubstring(String s, int k)
    {
        int count = 0;
        for (int i = 0; i< s.length(); i++)
        {
            int[] frequencyArray = new int[MAX_CHAR];
            for (int j = i; j<s.length(); j++)
            {
                int index = Character.getNumericValue(s.charAt(j));
                frequencyArray[index]++;
                if (frequencyArray[index] > k)
                    break;

                else if (frequencyArray[index] == k &&
                        check(frequencyArray, k))
                    count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(perfectSubstring("1221221121",3));
    }
}
