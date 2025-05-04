import java.util.*;

class LongestPalindrome {
    public static void main (String[] args){
        //This solution beats 100% according to leetcode, LOL

        String s = "A man, a plan, a canal: Panama";
        s = "baaabadad";
        System.out.println("FINAL RESPONSE ====> " + longestPalindrome(s.toLowerCase()));

    }

    public static String longestPalindrome(String s) {

        char [] array= s.toLowerCase().toCharArray();

        int l = 0;
        int r = array.length -1 ;
        Map<Integer , String > map = new HashMap<>();
        char[] t = new char[array.length];
        String largestPalindrome = "";

        for (int i = 0; i < array.length -1 ; i++){
            l = i;
            r = array.length-1;
            while (r > l) {
                if ( array[r] == array[l]){
                    //Check for palindrome
                     t = s.substring(l , r+1).toCharArray();
                     if(isPalindrome(t)){
                         if(t.length > largestPalindrome.length()){
                             largestPalindrome = new String(t);
                         }
//                         if(map.containsKey(l)){
//                             if(map.get(l).length() < t.length)
//                                 map.put(l , Arrays.toString(t));
//
//                         }else
//                             map.put(l , Arrays.toString(t));
                     }
                }
                r--;
            }

        }

        if(largestPalindrome.isEmpty() && array.length >= 1) {
            char[] firstChar = {array[0]};
            largestPalindrome = new String(firstChar);
        }

        map.forEach((key, value) -> {
            System.out.println("Key :" + key +  ": Value:" + value);
        });


        return largestPalindrome;
    }

    private static Boolean isPalindrome (char[] a){
        int l= 0;
        int r = a.length -1;
        Boolean isPalindrome = false;

        if(a.length == 1)
            return true;

        while (r>l){

            if(a[r] == a[l]){
                System.out.println("Comparing left char " + a[l ]  + " with right char " + a[r] );
                r--;
                l++;
                isPalindrome = true;
            }
            else {
                System.out.println("Comparing left char " + a[l ]  + " with right char " + a[r] );
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;

    }

    private int lo, maxLen;

    public String longestPalindromeByLeetCode(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }






}
