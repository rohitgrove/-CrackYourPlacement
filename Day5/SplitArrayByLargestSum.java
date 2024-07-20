public class SplitArrayByLargestSum {
    public static int splitArray(int[] Arr, int N, int M) {
        if (M > N) {
            return -1;
        }
        int s = 0;
        int e = 0;
        for (int i = 0; i < Arr.length; i++) {
            e += Arr[i];
        }

        int ans = -1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (isPossible(Arr, N, M, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }

            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static boolean isPossible(int Arr[], int N, int M, int sol) {
        int subArray = 1;
        int sizeOfSubArray = 0;
        for (int i = 0; i < N; i++) {
            if (sizeOfSubArray + Arr[i] <= sol) {
                sizeOfSubArray += Arr[i];
            } else {
                subArray++;
                if (subArray > M || Arr[i] > sol) {
                    return false;
                }
                sizeOfSubArray = 0;
                sizeOfSubArray += Arr[i];
            }
        }
        return true;
    }

    public static int splitArray(int[] nums, int k) {
        int ans = splitArray(nums, nums.length, k);
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 7, 2, 5, 10, 8 }, k1 = 2;
        System.out.println(splitArray(nums1, k1));
        int nums2[] = { 1, 2, 3, 4, 5 }, k2 = 2;
        System.out.println(splitArray(nums2, k2));
    }
}
