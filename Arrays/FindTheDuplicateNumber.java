import java.util.Arrays;

public class FindTheDuplicateNumber {
    public static int method1(int nums[]) {
        Arrays.sort(nums);
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                ans = nums[i];
                break;
            }
        }

        return ans;
    }

    public static int method2(int nums[]) {
        boolean visited[] = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (visited[index]) {
                return index;
            }

            visited[index] = true;
        }

        return -1;
    }
    public static int findDuplicate(int[] nums) {
        return method2(nums);
    }
    public static void main(String[] args) {
        int nums1[] = {1,3,4,2,2};
        System.out.println(findDuplicate(nums1));
        int nums2[] = {3,1,3,4,2};
        System.out.println(findDuplicate(nums2));
        int nums3[] = {3,3,3,3,3};
        System.out.println(findDuplicate(nums3));
    }
}