import java.util.Arrays;

public class MajorityElement {
    public static int bruteForce(int nums[]) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int optimizedApproach(int nums[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
        }

        int counts[] = new int[largest + 1];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }

        int halfSizeOfArray = nums.length / 2;
        int ans = -1;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= halfSizeOfArray) {
                ans = i;
                break;
            }
        }

        ans = ans + 1;
        return ans;
    }

    public static int majorityElement(int[] nums) {
        // return bruteForce(nums); O(nlogn)
        return optimizedApproach(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 2, 3 };
        System.out.println(majorityElement(nums1));
        int nums2[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums2));
    }
}