public class SubArraySumDivdeByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int[] fr = new int[k];
        fr[0] = 1; 
        int counter = 0;
        int ans = 0;
        
        for (int num : nums) {
            if (num >= 0) {
                counter += num;
            } else {
                counter += (num % k) + k;
            }
            counter %= k;
            ans += fr[counter];
            fr[counter]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 4, 5, 0, -2, -3, 1 }, k1 = 5;
        System.out.println(subarraysDivByK(nums1, k1));
        int nums2[] = { 5 }, k2 = 9;
        System.out.println(subarraysDivByK(nums2, k2));
    }
}
