package com.project.darphe.mywebapp.controller;

public class LongestPalindrome {
    public static void main(String[] args){
        System.out.println("Longes pallindrom in <ABdcbbdadbbcAB> is:" +longestPallindrome("ABdcbbdadbbcAB"));
    }

    public static int longestPallindrome(String s) {
        int longestPalindrome = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                int start = i, end = j;
                String substring = s.substring(i, j);
                int len = substring.length();
                if (isPallindrome(substring) && len > longestPalindrome) {
                    longestPalindrome = len;
                }
            }
        }
        return longestPalindrome;
    }

    private static boolean isPallindrome(String s) {
        return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
    }
}
