import java.util.Arrays;
import java.util.Scanner;

public class AggrassiveCows {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int s = 0;
        int e = stalls[stalls.length - 1] - stalls[0];

        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isPossible(stalls, k, mid)) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int stalls[], int k, int mid) {
        // can be place k cows, with at last mid distance between cows.

        int cowsCount = 1;
        int lastPos = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= mid) {
                cowsCount++;
                if (cowsCount == k) {
                    return true;
                }
                lastPos = stalls[i];
            } 
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] stalls = new int[n];
            for (int i = 0; i < n; i++) {
                stalls[i] = sc.nextInt();
            }
            int ans = solve(n, k, stalls);
            System.out.println(ans);
        }
        sc.close();
    }
}