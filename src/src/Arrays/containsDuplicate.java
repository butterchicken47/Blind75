package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class containsDuplicate {
    public boolean containsDuplicateByLeetCode(int[] nums) {
        List<Integer> responseList = new ArrayList();

    

        final int length = nums.length;
        if (length == 1)
            return false;
        if (length == 2)
            return nums[0] == nums[1];

        for (int i = 1; i < length; i++) {
            final int current = nums[i];
            int j = i - 1, jval = nums[j];
            if (current < jval) {
                while (true) {
                    nums[j + 1] = jval;
                    if (j-- == 0)
                        break;
                    jval = nums[j];
                    if (current >= jval)
                        break;
                }
                nums[j + 1] = current;
            }

            if (j > -1 && current == jval)
                return true;
        }

        return false;
    }

    public boolean containsDuplicateByMe(int[] nums) {
        Set<Integer> intSet = new HashSet<Integer>();

        for (int i : nums){
            if(intSet.contains (i))
            return true;

            intSet.add(i);

        }
        return false;
    }

}