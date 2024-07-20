import java.util.Arrays;

public class MAximumProduct {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans1 = 1;

        // Calculating product of two smallest numbers
        for (int i = 0; i < 2; i++) {
            ans1 *= nums[i];
        }

        long ans2 = 1;
        // Multiplying the smallest two with the largest
        ans1 *= nums[n - 1];
        // Calculating product of three largest numbers
        for (int i = n - 1; i >= n - 3; i--) {
            ans2 *= nums[i];
        }

        return (int) Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3 };
        System.out.println(maximumProduct(nums1));
        int nums2[] = { 1, 2, 3, 4 };
        System.out.println(maximumProduct(nums2));
        int nums3[] = { -1, -2, -3 };
        System.out.println(maximumProduct(nums3));
    }
}