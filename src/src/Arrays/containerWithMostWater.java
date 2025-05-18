package Arrays;

import java.util.Arrays;
import java.util.List;

public class containerWithMostWater {

    public static void main (String[] args){

//        int [] nums = {1,8,6,2,5,4,8,3,7};
        int[] nums = {1,3,2,100,100};
        System.out.println("RESPONSE IS " + maxArea(nums));
    }

    public static int maxArea(int[] height) {
       int l = 0;
       int r = height.length -1;
       int maxP = 1;

       while (l < r){
           int breadth = r-l;
           int length = Math.min(height[l], height[r]);
           int area  = length*breadth;
           maxP = Math.max(area , maxP);
           if(height[l] < height[r] )
               l++;
           else
               r--;

       }
       return maxP;
    }


}
