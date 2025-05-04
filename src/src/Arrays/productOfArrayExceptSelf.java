package Arrays;

class productOfArrayExceptSelf {

    public int[] productExceptSelfByLeetCode(int[] nums) {
            int[] res = new int[nums.length];
    
            for(int i = 0 ; i < nums.length ; i++) {
                res[i] = 1;
            }
    
            int pos = 1;
            for(int i = 0 ; i < nums.length ; i++) {
                res[i] = res[i] * pos;
                pos = pos * nums[i];
            }
    
            pos = 1;
            for(int i = nums.length - 1; i >= 0 ; i--) {
                res[i] = res[i] * pos;
                pos = pos * nums[i];
            }
            return res;
    
    }




    public int[] productExceptSelfByMe(int[] nums) {
        int [] resultArray = new int[nums.length];
       
        int [] preProductArray = getPreProduct (nums);
        int [] postProductArray = getPostProduct (nums);

        for (int i = 0 ; i < nums.length ; i++){
            resultArray [i] = preProductArray [i] * postProductArray [i];
        }
        return resultArray ;
    }

    private int[] getPreProduct(int[] nums) {
        int[] preArray = new int[100000];
        int productOfAllBefore = 1;
        for (int i = 0 ; i < nums.length ; i ++) {
            if(i==0)
            preArray [i] = 1;
            else {
            productOfAllBefore *= nums[i-1];
            preArray[i] = productOfAllBefore;
            }
        }
        return preArray;
    }

     private int[] getPostProduct(int[] nums) {
        int[] postArray = new int[100000];
        int productOfAllAfter = 1;
        for (int i = nums.length-1 ; i >= 0 ; i --) {
            if(i==nums.length-1)
            postArray [i] = 1;
            else {
            productOfAllAfter *= nums[i+1];
            postArray[i] = productOfAllAfter;
            }
        }
        return postArray;
    }
}