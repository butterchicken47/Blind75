import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagram {
    public static void main (String[] args){
        //This solution beats 100% according to leetcode, LOL


        String s = "anagram";
        String t = "nagaram";
        String[] arr = new String[20];
        System.out.println("FINAL RESPONSE ====> " + groupAnagrams(arr));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {


        List<List<String>> response = new ArrayList<>();
        HashMap<String , List<String>> sortedToList = new HashMap<>();
        for (String str : strs ) {
            char[] a = str.toCharArray();
            Arrays.parallelSort(a);
            if(! sortedToList.containsKey(Arrays.toString(a))) {
                List<String> list = new ArrayList<>();
                list.add(str);
                sortedToList.put(Arrays.toString(a), list);
            }
            else {
                List<String> list =  sortedToList.get(Arrays.toString(a));
                list.add(str);
                sortedToList.put(Arrays.toString(a), list);
            }
        }
        return sortedToList.values().stream().toList();

    }





}
