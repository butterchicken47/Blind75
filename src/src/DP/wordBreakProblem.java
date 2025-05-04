package DP;

import java.util.Arrays;
import java.util.List;

class wordBreakProblem {

    public static void main (String[] args){

//        String s = "leetCode";
//        List<String> dictList = Arrays.asList("leet" , "Code");

        String s = "catsand";
        List<String> dictList = Arrays.asList("cat" , "cats" , "and");

        System.out.println("RESPONSE IS " + wordBreak(s , dictList));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        char [] arr = s.toCharArray();
        int l= 0;
        int r = 1;
        boolean wordFound = false;

        return f (s , l , r , wordDict );

    }

    public static boolean f (String s , int l , int r , List<String> dict ){

        System.out.println("Value of r " + r +" L :" + l);

        if(l==r && r == s.length()){
            return true;
        }
        if(r > s.length() )
            return false;

        if(dict.contains(s.substring(l,r))){
            System.out.println("Found the word " + s.substring(l,r));
            boolean wordFound = f(s, r, r , dict );
            return wordFound;
        }
        else {
            System.out.println("Couldn't Found the word " + s.substring(l,r));

            return f(s, l, r + 1, dict);
        }

    }



}
