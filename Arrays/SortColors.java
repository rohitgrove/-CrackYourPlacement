public class SortColors {
    public static void method1(int nums[]) {
        int zero = 0, one = 0, two = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr == 0) {
                zero++;
            } else if (curr == 1) {
                one++;
            } else if (curr == 2) {
                two++;
            }
        }

        int i = 0;
        while (zero > 0) {
            nums[i] = 0;
            zero--;
            i++;
        }
        
        while (one > 0) {
            nums[i] = 1;
            one--;
            i++;
        }

        while (two > 0) {
            nums[i] = 2;
            two--;
            i++;
        }
    }

    public static void method2(int nums[]) {
        int start = 0, mid = 0, end = nums.length - 1;
        while (mid <= end) {
            if (nums[mid] == 0) {
                int temp = nums[start];
                nums[start] = nums[mid];
                nums[mid] = temp;
                start++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = temp;
                end--;
            }
        }
    }

    public static void sortColors(int[] nums) {
        method2(nums);
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums1);
        printArr(nums1);
        int nums2[] = { 2, 0, 1 };
        sortColors(nums2);
        printArr(nums2);
    }
}
