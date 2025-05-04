package Arrays;

class SearchInRotatedSubArray {
    public static void main (String[] args){
        //This solution beats 100% according to leetcode, LOL


        int target = 1;
        int[] nums = {1,3};

        // System.out.println(searchByBinarySearcch(nums , target));
        int pos= 0;
        int pivotIndex = findPivot(nums, 0, nums.length-1);
        System.out.println("Found pivot index as " + pivotIndex);

        if(nums[pivotIndex] == target)
        System.out.println("YO");

        if(target >= nums[0] && target <= nums [pivotIndex])
        pos = searchInSubArray(nums, 0, pivotIndex, target);
        else 
        pos = searchInSubArray(nums, pivotIndex+1, nums.length-1, target);

         System.out.println("Index of target element is" + pos);
    }
    public static int searchByBinarySearcch (int [] nums , int l , int r , int target){
        // int l = 0, r = nums.length - 1;
    
        if(nums.length == 1){
              if(nums[0] == target)
              return nums[0];
              else return -1;
        }


        while (l>=r) {
            int m =  (r + l) / 2;

            if (nums[m] == target)
                return m;
           
            if (nums[l] < target)
                r = m ;
            else
                l = m ;
        }

        return -1;
    }

    public static int findPivot (int[] nums , int start , int end ){
        int pivot = getMidIndex (start , end); 
         if (pivot != end && nums [pivot + 1] < nums [pivot]  )
         return pivot;
         if(nums[pivot] < nums[end]){
            //We know pivot will be on the left side of the array
            return findPivot(nums, start, pivot);
         }
         else if(nums[pivot] > nums[end]) {
            return findPivot(nums, pivot, end);
         }
         return pivot;

    }
    
    public static int searchInSubArray (int[] nums , int start , int end , int target){
        System.out.println("Value os start " + start + " end " + end);
        int midIndex = getMidIndex (start , end); 
   
        
        if(target == nums[midIndex])
        return midIndex; 
        else if (target == nums[end])
        return end;
        else if (target == nums[start])
        return start;    

        if( midIndex == start || midIndex == end)
        return -1; 
        
                if(target < nums[midIndex]){
                    return searchInSubArray (nums , start , midIndex , target);
                }
                else if (target > nums[midIndex]){
                   return searchInSubArray (nums , midIndex , end , target);
                }
                return -1;  
    }

    public static int searchWithPivot (int[] nums , int start , int end , int pivotIndex , int target){
        int midIndex = getMidIndex (start , end); 
        if(start==end || midIndex == start || midIndex == end)
        return -1; 
        
        if(target == nums[midIndex])
        return midIndex; 
        else if (target == nums[end])
        return end;
        else if (target == nums[start])
        return start;    
        
                if(target > nums[start]){
                    return searchInSubArray (nums , start , midIndex , target);
                }
                else if (target < nums[end]){
                   return searchInSubArray (nums , midIndex , end , target);
                }
                return -1;  
    }
    public static int getMidIndex (int start , int end){
        return (start + end) /2 ;
    }
    
}
