package Arrays;

import java.util.*;
class threesome {

    public static void main (String[] args){
        // int[] nums = {-1,0,1,2,-1,-4};
        // int [] nums = {1,2,-2,-1};
        int[] nums = {34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};

        int[][] expectedOutputArray = {{-82,-11,93},{-82,13,69},{-82,17,65},{-82,21,61},{-82,26,56},{-82,33,49},{-82,34,48},{-82,36,46},{-70,-14,84},{-70,-6,76},{-70,1,69},{-70,13,57},{-70,15,55},{-70,21,49},{-70,34,36},{-66,-11,77},{-66,-3,69},{-66,1,65},{-66,10,56},{-66,17,49},{-49,-6,55},{-49,-3,52},{-49,1,48},{-49,2,47},{-49,13,36},{-49,15,34},{-49,21,28},{-43,-14,57},{-43,-6,49},{-43,-3,46},{-43,10,33},{-43,12,31},{-43,15,28},{-43,17,26},{-29,-14,43},{-29,1,28},{-29,12,17},{-14,-3,17},{-14,1,13},{-14,2,12},{-11,-6,17},{-11,1,10},{-3,1,2}};
        List<List<Integer>> actualOutput = threeSum(nums);
        List<List<Integer>> expectedOutputList = new ArrayList<>(); 

        for (int i = 0 ; i< expectedOutputArray.length ; i = i + 3 ){
            List<Integer> miniList = new ArrayList<>();
            miniList.add(expectedOutputArray[i][0]);
            miniList.add(expectedOutputArray[i][1]);
            miniList.add(expectedOutputArray[i][2]);
            expectedOutputList.add(miniList);
        }

       
        System.out.println( actualOutput);


        for (List <Integer> subList : expectedOutputList){

            if(! actualOutput.contains(subList)){
            System.out.println("Doesn't contain" + subList);
            }
        }
        System.out.println("Expected size list is " + expectedOutputArray.length);


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) 
                        j++;
                    

                    while (j < k && nums[k] == nums[k - 1]) 
                        k--;

                    j++;
                    k--;
                } else if (sum < 0) {
                    // Sum is less than zero, increment j to increase the sum
                    j++;
                } else {
                    // Sum is greater than zero, decrement k to decrease the sum
                    k--;
                }
            }
        }
        return ans;
    }


    //TODO hit roadblock with the below approach :(

    // public static List<List<Integer>> threeSum(int[] nums) {
    //     List<List<Integer>> responseList = new LinkedList<>();
    //     List<Integer> miniList = new LinkedList<>();
    //     int sum = 0;
    //     HashMap<Integer, List<Integer>> map = new HashMap<>();
    //     map.values().stream().forEach(a -> System.out.println(a));
        
    //     for (int j =0 ; j < nums.length - 1 ; j++){


    //       for(int i = j+1;i<nums.length;i++){

    //         if(map.containsKey(nums[i])){
    //             // System.out.println("Found 3 sum for value in array " + nums[i] + "with value of j as : " + nums[j]);

    //             List<Integer> remainingIndexList = map.get(nums[i]);

    //             if(! remainingIndexList.contains(i)){

    //             for(int k :remainingIndexList)
    //                 miniList.add(nums[k]);
                
    //             miniList.add(nums[i]);

    //             System.out.println(miniList);
    //             if(! responseList.contains(miniList)){
    //                 // System.out.println("HELLO");

    //             responseList.add(miniList);
    //             // map.remove(nums[i]);

    //             }

    //             miniList = new LinkedList();
    //             }
    //         }
    //         else{
    //             List<Integer> mapValue = new ArrayList();
    //             mapValue.add(i);
    //             mapValue.add(j);
    //             Integer key = sum - nums[j] - nums[i];

    //             // System.out.println("Adding value to the map key : " + key + " : value : " + nums[mapValue.get(0)] + " , " + nums[mapValue.get(1)]  );
    //             if(! map.keySet().contains(key))
    //             map.put(key, mapValue);
    //             else {
    //                 System.out.println("Found duplicate key for : " + key + " it has index value as " + map.get(key));
    //             // map.replace(key, mapValue);
    //             map.remove(key);
    //             map.put(key, mapValue);
                
          
    //             System.out.println("New value for key " + key + " values is : " + nums[i] + " , " + nums[j]);

    //             }
    //         }
    //     }
    //     }
    //     System.out.println("Size of the response list is : " + responseList.size());
    //     return responseList ;
    
    // }
    
}
