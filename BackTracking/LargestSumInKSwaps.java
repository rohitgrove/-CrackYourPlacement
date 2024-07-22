public class LargestSumInKSwaps {
    public static void solve(int ind, StringBuilder str, StringBuilder ans, int k) {
        if (k == 0 || ind >= str.length()) {
            if (str.toString().compareTo(ans.toString()) > 0) {
                ans.setLength(0);
                ans.append(str);
            }
            return;
        }
        
        char mx = str.charAt(ind);
        for (int i = ind; i < str.length(); i++) {
            if (i == ind) {
                solve(ind + 1, str, ans, k);
            }
            if (str.charAt(i) > mx) {
                swap(str, ind, i);
                solve(ind + 1, str, ans, k - 1);
                swap(str, ind, i);
            }
        }
    }

    public static void swap(StringBuilder str, int i, int j) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }
    
    public static String findMaximumNum(String str, int k) {
        StringBuilder ans = new StringBuilder();
        solve(0, new StringBuilder(str), ans, k);
        return ans.toString();
    }
    
    public static void main(String[] args) {
        String str = "129814999";
        int k = 4;
        System.out.println(findMaximumNum(str, k));  // Example usage
    }
}
