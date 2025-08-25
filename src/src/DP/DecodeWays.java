package DP;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "226";
        s= "2101";
        System.out.println("RESPONSE IS : " + numDecodings(s));
    }
    public int numDecodingsByLeetCode(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }



    public static Map<String, Integer> dp = new HashMap<>();
    public static Map<String , Character> map = new HashMap<>();
    public static void populateMap (){
        for (int i = 65 ; i < 91 ; i++)
            map.put(String.valueOf(i-64) , (char) i );
    }

    public static int numDecodings(String s) {
        populateMap();
        return getNumDecodings(s);

    }

    public static int getNumDecodings(String sub) {
        int n = 0;
        if (sub.isEmpty())
            return 1;
        for (int i = 1; i <= sub.length(); i++) {
            String firstPart = sub.substring(0, i);
            String secondPart = sub.substring(i);

            if (!map.containsKey(firstPart))
                continue;

            boolean firstPartBool = map.containsKey(firstPart);
            int secondPartPossibleCombinations = 0;

            if(dp.containsKey(secondPart)) {
                secondPartPossibleCombinations = dp.get(secondPart);
            }
            else {
                secondPartPossibleCombinations = getNumDecodings(secondPart);
                if(! secondPart.isEmpty())
                    dp.put(secondPart , secondPartPossibleCombinations);
            }
            if (firstPartBool && secondPartPossibleCombinations > 0) {
                n = n + secondPartPossibleCombinations;
            }

        }

        return n;

    }

}
