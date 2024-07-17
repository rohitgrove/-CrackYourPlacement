import java.util.*;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                continue;
            } else {
                count++;
            }
        }
        if (target < 0 && count == 0) {
            return new ArrayList<>(result);
        }

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[left]);
                        quadruplet.add(nums[right]);

                        result.add(quadruplet);

                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 0, -1, 0, -2, 2 }, target1 = 0;
        System.out.println(fourSum(nums1, target1));
        int nums2[] = { 2, 2, 2, 2 }, target2 = 8;
        System.out.println(fourSum(nums2, target2));
    }
}
