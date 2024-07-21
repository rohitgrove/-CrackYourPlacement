public class NumArray2 {
    private int N;
    private int[] sgt;

    public NumArray2(int[] nums) {
        N = nums.length;
        sgt = new int[2 * N + 1];
        
        for (int i = 0; i < N; i++) {
            sgt[N + i] = nums[i];
        }

        for (int i = N - 1; i > 0; i--) {
            sgt[i] = sgt[2 * i] + sgt[2 * i + 1];
        }
    }

    public void update(int index, int val) {
        index += N;
        sgt[index] = val;

        while (index > 1) {
            index /= 2;
            sgt[index] = sgt[2 * index] + sgt[2 * index + 1];
        }
    }

    public int sumRange(int left, int right) {
        left += N;
        right += N;

        int sum = 0;
        while (left <= right) {
            if ((left & 1) == 1) {
                sum += sgt[left];
                left++;
            }
            if ((right & 1) == 0) {
                sum += sgt[right];
                right--;
            }

            left = left >> 1;
            right = right >> 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray2 obj = new NumArray2(nums);
        System.out.println(obj.sumRange(0, 2)); // Output will be 9 (1+3+5)
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2)); // Output will be 8 (1+2+5)
    }
}
