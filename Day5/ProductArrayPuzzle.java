import java.util.Arrays;

public class ProductArrayPuzzle {
    public static long[] productExceptSelf(long[] nums, int n) {
        long[] ans = new long[n];
        long postfix = 1, prefix = 1;
        ans[0] = 1;

        for (int i = 0; i < n - 1; i++) {
            prefix *= nums[i];
            ans[i + 1] = prefix;
        }

        for (int i = n - 1; i > 0; i--) {
            postfix *= nums[i];
            ans[i - 1] *= postfix;
        }

        return ans;
    }

    public static void main(String[] args) {
        long[] nums1 = {10, 3, 5, 6, 2};
        System.out.println(Arrays.toString(productExceptSelf(nums1, nums1.length)));
        long[] nums2 = {12,0};
        System.out.println(Arrays.toString(productExceptSelf(nums2, nums2.length)));
    }
}
