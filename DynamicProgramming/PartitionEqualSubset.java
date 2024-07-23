import java.util.Arrays;

public class PartitionEqualSubset {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0)
            return false;

        return solveSO(nums, total);
    }
    public boolean solveSO(int[] nums, int total){
        Boolean[] curr = new Boolean[total + 1];
        Boolean[] next = new Boolean[total + 1];

        Arrays.fill(curr, false);
        Arrays.fill(next, false);

        curr[0] = true;
        next[0] = true;

        for(int index = nums.length - 1; index >= 0; index--){
            for(int target = 0; target <= total / 2; target++){
                boolean inc = false;
                if(target - nums[index] >= 0)
                    inc = next[target - nums[index]];
                
                boolean exc = next[target];

                curr[target] = (inc || exc);
            }
            next = curr.clone();
        }
        return next[total / 2];
    }    
}