import java.util.HashMap;
import java.util.Map;

public class FindPair {
    public static int findPair(int n, int x, int[] arr) {
        // Create a hashmap to store elements of the array
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            int num1 = x + arr[i];
            int num2 = arr[i] - x;

            // Check if either num1 or num2 is already in the hashmap
            if (map.containsKey(num1) || map.containsKey(num2)) {
                return 1;
            }

            // Add the current element to the hashmap
            map.put(arr[i], 1);
        }

        // If no such pair is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 20, 3, 2, 5, 80};
        int result = findPair(arr.length, 78, arr);
        System.out.println(result); 
    }
}
