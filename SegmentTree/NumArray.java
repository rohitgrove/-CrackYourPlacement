public class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        long x = 0;
        for (int i = left; i <= right; i++) {
            x += nums[i];
        }
        return (int) x;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(1, 3);
        System.out.println(param_1);  // Output will be 9 (2+3+4)
    }
}
