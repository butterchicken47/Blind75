import java.util.HashMap;
import java.util.Map;

class PalindromicSubstrings {
    public static void main (String[] args){
        //This solution beats 100% according to leetcode, LOL

        String s = "A man, a plan, a canal: Panama";
        s = "baaabadad";
        System.out.println("FINAL RESPONSE ====> " + longestPalindrome(s.toLowerCase()));

    }

    public static String longestPalindrome(String s) {


        return "";
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







}
