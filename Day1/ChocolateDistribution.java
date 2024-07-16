import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistribution {
    public static long findMinDiff(ArrayList<Integer> a, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        Collections.sort(a);

        if (n < m) {
            return -1;            
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int nextWindow = i + m - 1;
            if (nextWindow >= n) { 
                break;
            }

            int diff = a.get(nextWindow) - a.get(i);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(4);
        A.add(1);
        A.add(9);
        A.add(56);
        A.add(7);
        A.add(9);
        A.add(12);
        int N = A.size(), M = 5;
        System.out.println(findMinDiff(A, N, M));
    }
}
