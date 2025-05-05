package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class wordBreakProblem  extends Trie{

    public static void main (String[] args){

//        String s = "leetCode";
//        List<String> dictList = Arrays.asList("leet" , "Code");

        String s = "catsand";
//        s = "cats";
        List<String> dictList = Arrays.asList("cat" , "cats" , "and");

        System.out.println("RESPONSE IS " + wordBreak(s , dictList));

    }

        boolean[] memo;
        public boolean wordBreakByLeetCode(String s, List<String> wordDict) {
            memo = new boolean[s.length() + 1];
            return wordBreak(s, wordDict, 0);
        }
        boolean wordBreak(String s, List<String> wordDict, int k) {
            if (k == s.length())
                return true;

            if (memo[k])
                return false;

            for (String word : wordDict) {
                if (s.startsWith(word, k)) {
                    memo[k] = true;
                    if(wordBreak(s, wordDict, k + word.length())) return true;
                }
            }
            return false;
        }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node();
        char [] arr = s.toCharArray();
        int l= 0;
        int r = 1;
        boolean wordFound = false;

        for (String word : wordDict)
            insert(word , root);


        return searchSubstring(s , root );
//        return f (s , l , r , wordDict );

    }
    public static  HashMap<String , Boolean> map = new HashMap<>();

    public static boolean searchSubstring (String key , Node trie ){
        if(key.isEmpty())
            return true;

        for (int i = 1 ;i <= key.length(); i ++){
            String firstPart = key.substring(0,i);
            String secondPart = key.substring(i);
            Boolean secondPartBool = false;
            if(! map.containsKey(secondPart)) {
                secondPartBool = searchSubstring(secondPart, trie);
                map.put(secondPart , secondPartBool);
            }else
                secondPartBool = map.get(secondPart);

            if(search(firstPart , trie) && secondPartBool) {
                return true;
            }
        }
        return false;

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
