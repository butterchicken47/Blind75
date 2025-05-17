package DP;

public class houseRobber {

    public static void main (String[] args){
//        Integer [] nums = {1,2,3,1};

//        Integer [] nums = {2,1,1,2};
        Integer [] nums = {2,7,9,3,1};
//        Integer [] nums = {1,3,1,3,100};
        System.out.println("RESPONSE IS " + robByLeetCode(nums));
    }

    public static Integer[] dp = new Integer[100];

    //TODO look for optimisations
    public static int robIterative (Integer[] nums){
        int maxAll = 0;

        for (int i = 0 ; i <nums.length ; i++){
            int max = nums[i];
            for (int j= 0; j <=i-2 ; j++ ){
                max = Math.max(dp[j] + nums[i] , max);
            }
            dp[i] = max;
            maxAll = Math.max(max , maxAll);
        }


        return maxAll;
    }


    public static int robByLeetCode (Integer[] nums){

                int n = nums.length;
                int dp[] = new int[n];
                dp[0]=nums[0];
                if(n==1){
                    return nums[0];
                }

                dp[1] = Math.max(nums[0],nums[1]);

                for(int i=2;i<n;i++){
                    dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
                }


        return dp[n-1];

    }

}
