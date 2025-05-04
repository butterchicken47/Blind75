import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String s = "ADOBECODEBANC";
        String t  = "ABC";
        System.out.println("FINAL RESPONSE ====== " + minWindowLeet(s,t));
    }


    public static String minWindow(String s, String t) {

        HashMap <Character , Integer> tFreqMap = new HashMap<>();
        HashMap <Character , Integer> sFreqMap = new HashMap<>();

        for ( int i = 0; i < t.length() ; i++ ){
            char a = t.charAt(i);
            if(tFreqMap.containsKey(a)){
                int f = tFreqMap.get(a);
                f++;
                tFreqMap.put(a , f);
            }
            else {
                tFreqMap.put(a , 1);
            }
        }
        tFreqMap.entrySet().forEach(System.out::println);
        System.out.println("===========");
        int l =0;
        int r = 1;
        int res = 999999;
        int minWindow = 9999999;
        String minimumString = "";
        String responseString = "";

        //ADOBECODEBANC  ABC

        while (r < l){
            char right = s.charAt(r);
            char left  = s.charAt(l);
            if(sFreqMap.equals(tFreqMap)){
                sFreqMap.entrySet().forEach(System.out::println);
                System.out.println("Value of substring here"  + s.substring(l,r));
                l++;
                if (sFreqMap.containsKey(left)) {
                    int f = sFreqMap.get(left);
                    f--;
                    if(f == 0)
                        sFreqMap.remove(left);
                    else
                        sFreqMap.put(left, f);
                }
            }
            else {
                if(! tFreqMap.containsKey(left)                                        )
                    l++;
                else {
                    if (tFreqMap.containsKey(right)) {
                        if (sFreqMap.containsKey(right)) {
                            int f = sFreqMap.get(right);
                            f++;
                            sFreqMap.put(right, f);
                        } else
                            sFreqMap.put(right, 1);

                        r++;
                    }
                }
            }

        }
        System.out.println("Value of l : " + l + "Value of right : " + r);
        sFreqMap.entrySet().forEach(System.out::println);

        return s.substring(l,r);
    }

//    public int characterReplacement(String s, int k) {
//
//       char [] charray =  s.toCharArray();
//       HashMap <Character , Integer> map = new HashMap<>();
//       int max = 0;
//       int currMax = 0;
//       int l = 0;
//       int r = 0;
//
//       for (int i = 0; i < charray.length ; i ++){
//           char charAtI = charray[i];
//
//           if(! map.containsKey(charAtI))
//               map.put(charAtI , i);
//           else {
//               Integer lastIndex = map.get(charAtI);
//               if( (i - lastIndex) > 0 ){
//                   currMax = i-lastIndex;
//
//               }
//
//
//
//           }
//
//
//       }
//
//
//    }

    public static String minWindowLeet(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<>();

        int ans = Integer.MAX_VALUE;
        int start = 0;

        for (char x : t.toCharArray())
            mp.put(x, mp.getOrDefault(x, 0) + 1);

        int count = mp.size();
        System.out.println("Count value is  " + count);

        int i = 0, j = 0;

        //ADOBECODEBANC  ABC
        while (j < s.length()) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) - 1);
            if (mp.get(s.charAt(j)) == 0) {
                System.out.println("Decreasing count for value " + s.charAt(j));
                count--;
            }

            if (count == 0) {
                System.out.println("Count was 0 when j was " + j);
                while (count == 0) {
                    if (ans > j - i + 1) {
                        ans = j - i + 1;
                        start = i;
                    }
                    mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
                    if (mp.get(s.charAt(i)) > 0)
                        count++;

                    i++;
                }
            }
            j++;
        }
        if (ans != Integer.MAX_VALUE)
            return s.substring(start, start + ans);
        else
            return "";
    }



}