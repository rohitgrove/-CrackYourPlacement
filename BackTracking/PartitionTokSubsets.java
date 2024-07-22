import java.util.Arrays;

public class PartitionTokSubsets {

    static int count = 0;

    public static boolean solve(int[] a, int n, int index, int curr_sum, int target, boolean[] visit) {
        if (index >= n) {
            return false;
        }

        if (curr_sum > target) {
            return false;
        }

        if (curr_sum == target) {
            count++;
            return true;
        }

        for (int i = index; i < n; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            boolean completed = solve(a, n, index + 1, curr_sum + a[i], target, visit);

            if (completed) return true;
            visit[i] = false;
        }

        return false;
    }

    public static boolean isKPartitionPossible(int[] a, int n, int k) {
        if (k == 1) return true;

        int sum = Arrays.stream(a).sum();
        boolean[] visit = new boolean[n];

        if (sum % k != 0) return false;

        Arrays.sort(a);
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }

        for (int i = 0; i < k; i++) {
            solve(a, n, 0, 0, sum / k, visit);
        }

        return count == k;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 5, 3, 3};
        int n = a.length;
        int k = 3;
        if (isKPartitionPossible(a, n, k)) {
            System.out.println("Partition is possible");
        } else {
            System.out.println("Partition is not possible");
        }
    }
}
