import java.util.ArrayList;

public class PalindromicPermutations {
    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void solve(String S, int idx, ArrayList<String> temp, int n, ArrayList<ArrayList<String>> result) {
        if (idx == n) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < n; i++) {
            if (isPalindrome(S, idx, i)) {
                temp.add(S.substring(idx, i + 1));
                solve(S, i + 1, temp, n, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        int n = S.length();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        solve(S, 0, temp, n, result);
        return result;
    }

    public static void main(String[] args) {
        String S = "aab";
        ArrayList<ArrayList<String>> palindromicPerms = allPalindromicPerms(S);
        for (ArrayList<String> perm : palindromicPerms) {
            System.out.println(perm);
        }
    }
}