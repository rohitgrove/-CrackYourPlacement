import java.util.Arrays;

public class PermutationInAnArray {
    public static boolean isPossible(long[] arr1, long[] arr2, int n, long k) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            if (arr1[i] + arr2[j] < k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long a[] = { 2, 1, 3 },
                b[] = { 7, 8, 9 },
                k = 10;
        System.out.println(isPossible(a, b, a.length, k));
    }
}
