package DP;

import java.util.*;
class increasingSubsequence {

    public static void main (String[] args){

        // int[] input = {1,2,5};
        // int sum = 11;

        // int[] input = {10,9,2,5,3,7,101,18};
        int[] input = {0,1,0,3,2,3};

        System.out.println("RESPONSE IS " + lengthOfLIS(input));

    }

    public static int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length]; 
        lis[0] = 1;
        int response = 1;
        //0,1,0,3,2,3
        int maxInit = 0;
        int maxAll = 0;

        for (int i = 0 ; i < nums.length ; i++){
            maxAll = 0;
            for (int k = 0 ; k < i ; k++){
                //Find the max
                if(nums[k] < nums[i]) {
                    //try finding the max of all possibilities till i
                    maxInit = lis[k];
                    if(maxInit >maxAll )
                        maxAll = maxInit;
                }
            }
            System.out.println("value of maxInSubSet after inner loop ends" + maxAll);
            lis[i] = 1 + maxAll;

            if(lis[i] > response)
                response = lis[i];
        }

        Arrays.stream(lis).forEach(System.out::println);


        return response;
    
    }



}
