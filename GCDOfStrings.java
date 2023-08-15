package com.mayank4java.algorithm;

public class GCDOfStrings {
	    public String gcdOfStrings(String str1, String str2) {

	        if(!(str1+str2).equals(str2+str1)) {
	            return "";
	        }
	        int len1 = str1.length();
	        int len2 = str2.length();
	        int minLen = Math.min(len1, len2);
	        int gcd = 1;

	        for(int i = 2; i <= minLen; i++ ) {
	            if(len1 % i == 0 && len2 % i == 0) {
	                gcd = i;
	            }
	        }
	        return str1.substring(0, gcd);
	    }
	}


/*

Problem Statement
For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English upper case letters.

**/