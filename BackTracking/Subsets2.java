import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    private static List<List<Integer>> result;
    private static int n;

    public Subsets2() {
        result = new ArrayList<>();
    }

    public static void solve(int[] nums, int idx, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int i = idx; i < n; i++) {
            if (i != idx && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            solve(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        n = nums.length;
        Arrays.sort(nums);
        solve(nums, 0, temp);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = subsetsWithDup(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
