import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AllUniquePermutations {
    public static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> nums , int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();
        solve(nums, set, 0);
        
        // Convert the set to a list and sort it
        ans.addAll(set);
        Collections.sort(ans, (list1, list2) -> {
            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    return list1.get(i) - list2.get(i);
                }
            }
            return 0;
        });
        
        return ans;
    }
    public static void solve(ArrayList<Integer> nums, Set<ArrayList<Integer>> set, int index) {
        if (index >= nums.size()) {
            set.add(new ArrayList<>(nums));
            return;
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.size(); i++) {
            if (visited.contains(nums.get(i))) {
                continue;
            }
            visited.add(nums.get(i));
            Collections.swap(nums, index, i);
            solve(nums, set, index + 1);
            Collections.swap(nums, index, i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(1);
        nums1.add(2);
        nums1.add(3);
        System.out.println(nums1);
        System.out.println(uniquePerms(nums1, nums1.size()));
        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(1);
        nums2.add(1);
        nums2.add(2);
        System.out.println(nums2);
        System.out.println(uniquePerms(nums2, nums2.size()));
    }
}
