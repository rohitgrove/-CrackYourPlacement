public class ReversePairs {
    public static int bruteForce(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2L * nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void merge(int[] nums, int low, int mid, int high, int[] reversePairsCount) {
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > 2L * nums[j]) {
                j++;
            }
            reversePairsCount[0] += j - (mid + 1);
        }

        int size = high - low + 1;
        int[] temp = new int[size];
        int left = low, right = mid + 1, k = 0;

        while (left <= mid && right <= high) {
            if (nums[left] < nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        while (right <= high) {
            temp[k++] = nums[right++];
        }

        System.arraycopy(temp, 0, nums, low, size);
    }

    public static void mergeSort(int[] nums, int low, int high, int[] reversePairsCount) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid, reversePairsCount);
        mergeSort(nums, mid + 1, high, reversePairsCount);
        merge(nums, low, mid, high, reversePairsCount);
    }

    public static int optimizedApproach(int[] nums) {
        int[] reversePairsCount = { 0 };
        mergeSort(nums, 0, nums.length - 1, reversePairsCount);
        return reversePairsCount[0];
    }

    public static int reversePairs(int[] nums) {
        return (int) optimizedApproach(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3, 2, 3, 1 };
        System.out.println(reversePairs(nums1));
        int nums2[] = { 2, 4, 3, 5, 1 };
        System.out.println(reversePairs(nums2));
    }
}