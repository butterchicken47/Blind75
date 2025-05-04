package Arrays;

class maxSubArray {

    public int maxSubArrayByLeetCode(int[] nums) {
        int s=0,max=nums[0];
        for(int i=0 ; i<nums.length ; i++){
            s+=nums[i];
            max = s>max ? s : max;
            if(s<0)
                s=0;
        }
        return max;
    }
    
    public int maxSubArrayByMe(int[] nums) {
        int maxSoFar = 0;
        int maxEndingHere = -10001;

        for (int i : nums) {
            maxSoFar += i;
              if(i > maxSoFar)
              maxSoFar = i;

                if (maxSoFar > maxEndingHere)
                    maxEndingHere = maxSoFar;
    

        }
        return maxEndingHere;
    }
}