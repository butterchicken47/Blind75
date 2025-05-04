import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class ValidPalindrome {
    public static void main (String[] args){
        //This solution beats 100% according to leetcode, LOL

        String s = "A man, a plan, a canal: Panama";
        s = "a.";
        System.out.println("FINAL RESPONSE ====> " + isPalindrome(s.toLowerCase()));

    }

    public static boolean isPalindrome(String s) {

        char [] a = s.toLowerCase().toCharArray();
        int l= 0;
        int r = s.length()-1;
        System.out.println("Length of array is " + a.length);
        System.out.println("Length of String is " + s.length());

        Boolean isPalindrome = false;

        if(s.length() == 1)
            return true;

        while (r>l){

            int leftCharAscii = a [l];
            int rightCharAscii = a[r];

            if( ! ((47 < leftCharAscii && leftCharAscii < 58) || ( 96< leftCharAscii && leftCharAscii < 123))){
                l++;
                if(l==r)
                    isPalindrome = true;
                continue;
            }
            if( ! ((47 < rightCharAscii && rightCharAscii < 58) || ( 96< rightCharAscii && rightCharAscii < 123))){
                r--;
                if(l==r)
                    isPalindrome = true;
                continue;
            }
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
