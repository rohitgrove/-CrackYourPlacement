import java.util.HashMap;

public class SubArraySum {
    public static int bruteForce(int nums[], int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int optimizedApproach(int nums[], int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static int subarraySum(int[] nums, int k) {
        // return bruteForce(nums, k);
        return optimizedApproach(nums, k);
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3 };
        int k1 = 3;
        System.out.println(subarraySum(nums1, k1));
        int[] nums2 = { 1, 1, 1 };
        int k2 = 2;
        System.out.println(subarraySum(nums2, k2));
    }
}
