import java.util.HashMap;

public class SubarraySumZero {
    public static int maxLen(int[] arr, int n) {
        int max_size = 0; // It will store the max size of subarray having sum = 0
        int prefix_sum = 0;
        HashMap<Integer, Integer> first_occ = new HashMap<>();

        first_occ.put(0, -1);

        for (int i = 0; i < n; i++) {
            prefix_sum += arr[i];
            if (!first_occ.containsKey(prefix_sum)) { // if prefix_sum does not exist in hashmap
                first_occ.put(prefix_sum, i); // setting its first occurrence
            }

            int curr_size = i - first_occ.get(prefix_sum);
            max_size = Math.max(max_size, curr_size);
        }

        return max_size;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -2, 4, -4};
        int n = arr.length;
        System.out.println("Maximum length of subarray with sum 0 is: " + maxLen(arr, n));
    }
}
