import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

class ValidAnagram {
    public static void main (String[] args){
        //This solution beats 100% according to leetcode, LOL


        String s = "anagram";
        String t = "nagaram";
        System.out.println("FINAL RESPONSE ====> " + isAnagram2(s,t));

    }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<>();
        HashMap<Character, Integer> mpt = new HashMap<>();


        for (char x : s.toCharArray())
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        for (char x : t.toCharArray())
            mpt.put(x, mpt.getOrDefault(x, 0) + 1);

        if(mp.equals(mpt))
            return true ;
        else
            return false;
    }

    public static boolean isAnagram2(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
//
//        Arrays.sort(a);
//        Arrays.sort(b);

        Arrays.parallelSort(a);
        Arrays.parallelSort(b);


        System.out.println("==" + Arrays.toString(a) + "==");
        System.out.println("==" + Arrays.toString(b) + "==");

        System.out.println("Return obj " + Arrays.equals(a,b) );

        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
//        return true;
    }





}
