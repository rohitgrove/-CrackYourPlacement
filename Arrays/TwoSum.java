import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }

            map.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 7, 11, 15 }, target1 = 9;
        printArr(twoSum(nums1, target1));
        int nums2[] = { 3, 2, 4 }, target2 = 6;
        printArr(twoSum(nums2, target2));
        int nums3[] = { 3, 3 }, target3 = 6;
        printArr(twoSum(nums3, target3));
    }
}