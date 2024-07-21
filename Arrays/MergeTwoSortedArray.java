public class MergeTwoSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1mergep2 = m + n - 1;
        int idx1 = m - 1;
        int idx2 = n - 1;

        while (idx2 >= 0) {
            if (idx1 >= 0 && nums1[idx1] > nums2[idx2]) {
                nums1[p1mergep2--] = nums1[idx1--];
            } else {
                nums1[p1mergep2--] = nums2[idx2--];
            }
        }
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int nums2[] = { 2, 5, 6 };
        int n = 3;
        merge(nums1, m, nums2, n);
        printArr(nums1);
    }
}
