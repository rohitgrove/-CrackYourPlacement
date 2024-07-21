public class SmallestPositiveNumber {
    public static int missingNumber(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i] <= 0 || arr[i] > size) {
                arr[i] = size + 1;
            }
        }

        for (int i = 0; i < size; i++) {
            int num = Math.abs(arr[i]);
            if (num <= size) {
                arr[num - 1] = -Math.abs(arr[num - 1]);
            }
        }

        for (int i = 0; i < size; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return size + 1;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5 };
        System.out.println(missingNumber(nums, nums.length));
        int arr[] = { 0, -10, 1, 3, -20 };
        System.out.println(missingNumber(arr, arr.length));
    }
}
