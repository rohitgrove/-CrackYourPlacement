public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        int result[] = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[j] = nums[i];
                j++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 0, 3, 12 };
        moveZeroes(nums);
        printArr(nums);
    }
}
