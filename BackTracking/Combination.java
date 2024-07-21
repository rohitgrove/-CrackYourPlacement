import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(n, 1, k, temp, result);
        return result;
    }

    public static void solve(int n, int idx, int k, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i <= n; i++) {
            temp.add(i);
            solve(n, i + 1, k, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
