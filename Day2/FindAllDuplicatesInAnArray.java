import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int count[] = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                duplicates.add(i);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        int nums1[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDuplicates(nums1));
        int nums2[] = { 1, 1, 2 };
        System.out.println(findDuplicates(nums2));
    }
}