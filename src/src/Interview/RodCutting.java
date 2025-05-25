package Interview;

import java.util.Arrays;

public class RodCutting {
    //Question Link --  https://www.geeksforgeeks.org/problems/rod-cutting0840/1
    //Explaination Link -- https://www.geeksforgeeks.org/cutting-a-rod-dp-13/

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println("Response is :" + cutRod(prices) );
    }

    public static int cutRod (int[] prices){
        int rodLength = prices.length;
        int[] dp = new int[prices.length];
        Arrays.fill(dp, -1);
        return cutRodRecur(rodLength , prices  , dp);
    }

    static int cutRodRecur(int i, int[] price, int[] memo) {

        if (i == 0) return 0;

        if (memo[i - 1] != -1) return memo[i - 1];

        int ans = 0;

        for (int j = 1; j <= i; j++) {
            ans = Math.max(ans, price[j - 1] + cutRodRecur(i - j, price, memo));
        }

        return memo[i - 1] = ans;
    }


}