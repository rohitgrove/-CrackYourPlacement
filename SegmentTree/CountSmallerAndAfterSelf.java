import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CountSmallerAndAfterSelf {
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> series = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int pos = findInsertPosition(series, nums[i]);
            series.add(pos, nums[i]);
            ans.add(pos);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static int findInsertPosition(List<Integer> series, int target) {
        int l = 0;
        int h = series.size();
        while (l < h) {
            int mid = (l + h) / 2;
            if (series.get(mid) >= target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] arr1 = { 5, 2, 6, 1 };
        System.out.println(countSmaller(arr1));
    }
}
