package DP;

public class houseRobber2 {

    public static void main (String[] args){
//        Integer [] nums = {1,2,3,1};

//        Integer [] nums = {2,1,1,2};
        Integer [] nums = {2,1,1,1};
//        Integer [] nums = {1,3,1,3,100};
        System.out.println("RESPONSE IS " + robByLeetCode(nums));
    }

    public static Integer[] dp = new Integer[100];


    public static int robByLeetCode (Integer[] nums){
                int n = nums.length;
                int dp[] = new int[n];
                if(n==1)
                    return nums[0];

                if(n==2)
                    return Math.max(nums[0],nums[1]);
                int ifFirstRobbed = 0;
                int ifLastRobbed = 0;

                dp[0]=nums[0];
                dp[1] = Math.max(nums[0],nums[1]);
                for(int i=2;i<n-1;i++){
                    dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
                }
                ifFirstRobbed = dp[n-2];

                dp[1]=nums[1];
                dp[2] = Math.max(nums[1],nums[2]);

                for(int i=3;i<n;i++){
                    dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
                }
                ifLastRobbed = dp[n-1];

        System.out.println("Values if first robbed " + ifFirstRobbed);
        System.out.println("Values if last robbed " + ifLastRobbed);
        return Math.max(ifFirstRobbed , ifLastRobbed);
    }

}
