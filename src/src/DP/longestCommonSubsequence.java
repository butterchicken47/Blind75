package DP;

import java.util.Arrays;

public class longestCommonSubsequence {


    public static void main (String[] args){

        // int[] input = {1,2,5};
        // int sum = 11;

        // int[] input = {10,9,2,5,3,7,101,18};
        String text1 = "dbcea";
        text1 = "abcde";
        String text2 = "ace";

//        System.out.println("RESPONSE IS " + longestCommonSubsequence(text2 , text1));
        System.out.println("RESPONSE IS " + longestCommonSubsequene(text2 , text1));

    }

    private static int[][] dp = null;
    public static int lcs (int index1, int index2 , String text1 , String text2) {
        System.out.println("entering lcs with pram " + (index1) + " and " +index2 );

        if(index1 < 0 || index2 < 0)
            return 0;

        if(dp[index1][index2] != 0) {
            System.out.println("hererere");
            return dp[index1][index2];
        }

        if(text1.charAt(index1) ==  text2.charAt(index2)){
            System.out.println("matches " + text1.charAt(index1) + " with " + text2.charAt(index2) );
            return dp[index1][index2] = 1 + lcs(index1-1 , index2-1 , text1 , text2);
        }
        else {
            return dp[index1][index2]  = Math.max(  lcs(index1 , index2-1 , text1 , text2), lcs(index1-1 , index2 , text1 , text2) );
        }
    }
    public static int longestCommonSubsequene(String text1, String text2) {
        int m = text1.length();
        System.out.println("length is " + m);
        int n = text2.length();
        dp = new int[m][n];
        return lcs(m-1 , n-1 , text1 , text2);
    }
    public int longestCommonSubsequenceByLeetCode(String text1, String text2) {
        // Lengths of the input strings
        int length1 = text1.length();
        int length2 = text2.length();

        // Create a 2D array to store the lengths of longest common subsequences
        // for all subproblems, initialized with zero
        int[][] dp = new int[length1 + 1][length2 + 1];

        // Build the dp array from the bottom up
        for (int i = 1; i <= length1; ++i) {
            for (int j = 1; j <= length2; ++j) {
                // If characters match, take diagonal value and add 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // If characters do not match, take the maximum value from
                // the left (dp[i][j-1]) or above (dp[i-1][j])
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // The bottom-right cell contains the length of the longest
        // common subsequence of text1 and text2
        return dp[length1][length2];
    }




}
