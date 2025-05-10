package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class combinationSum4 {

    public static void main (String[] args){

//        int [] nums = {1,2,3};
//        int target = 3;

        int [] nums = {2,1,3};
        int target = 35;
        //actual 797691075
        //expected 1132436852

        System.out.println("RESPONSE IS " + combinationSum4(nums , target));
    }
    private static HashMap<Integer, Integer> map = new HashMap<>();
    private static Integer cache[] = new Integer[1001];

    public static int combinationSum4(int[] nums, int target) {

        int lc = 0;
        for (int a : nums) {
            if (a > target)
                continue;
            int remaining = target - a;
            if (remaining == 0) {
                lc++;
            } else if (cache[remaining] == null) {
                lc += combinationSum4(nums, remaining);
            } else {
                lc += cache[remaining];
            }
        }
        cache[target] = lc;

        return lc;
    }



}
