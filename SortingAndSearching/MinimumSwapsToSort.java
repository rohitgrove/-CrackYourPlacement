import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class MinimumSwapsToSort {
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            m.put(nums[i], i);
        }
        
        int[] temp = nums.clone();
        Arrays.sort(temp);
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == temp[i]) continue;
            ans++;
            m.put(nums[i], m.get(temp[i]));
            swap(nums, i, m.get(temp[i]));
        }
        
        return ans;
    }
    
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums1[] = {2, 8, 5, 4};
        System.out.println(minSwaps(nums1));
        int nums2[] = {10, 19, 6, 3, 5};
        System.out.println(minSwaps(nums2));
    }
}
