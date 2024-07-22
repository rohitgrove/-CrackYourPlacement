import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void solve(int i, int[] nums, List<Integer> temp, List<List<Integer>> result) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        solve(i + 1, nums, temp, result);
        temp.remove(temp.size() - 1);
        solve(i + 1, nums, temp, result);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        solve(0, nums, temp, result);
        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 2 };
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
