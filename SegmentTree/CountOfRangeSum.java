public class CountOfRangeSum {
    private static int count;

    public static int countRangeSum(int[] nums, int lower, int upper) {
        count = 0;
        int n = nums.length;
        long[] sums = new long[n + 1];

        for (int i = 0; i < n; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }

        countWhileMergingSort(sums, 0, n + 1, lower, upper);

        return count;
    }

    public static void countWhileMergingSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return;
        }

        int mid = (start + end) / 2;
        countWhileMergingSort(sums, start, mid, lower, upper);
        countWhileMergingSort(sums, mid, end, lower, upper);

        int j = mid, k = mid, t = mid;
        long[] merged = new long[end - start];

        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (j < end && sums[j] - sums[i] < lower) {
                j++;
            }
            while (k < end && sums[k] - sums[i] <= upper) {
                k++;
            }
            while (t < end && sums[t] < sums[i]) {
                merged[r++] = sums[t++];
            }
            merged[r] = sums[i];
            count += k - j;
        }

        System.arraycopy(merged, 0, sums, start, t - start);
    }

    public static void main(String[] args) {
        int nums[] = { -2, 5, -1 }, lower = -2, upper = 2;
        System.out.println(countRangeSum(nums, lower, upper));
    }
}