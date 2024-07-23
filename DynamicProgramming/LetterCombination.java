import java.util.List;
import java.util.ArrayList;

public class LetterCombination {
    public void solve(List<String> ans, String[] mapping, String str, int index, StringBuilder output) {
        // base case
        if (index >= str.length()) {
            if (!output.isEmpty()) {
                ans.add(String.valueOf(output));
            }
            return;
        }
        String temp = mapping[str.charAt(index) - '0'];

        for (int i = 0; i < temp.length(); i++) {
            output.append(temp.charAt(i));
            solve(ans, mapping, str, index + 1, output);
            output.deleteCharAt(output.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int index = 0;
        StringBuilder output = new StringBuilder();
        solve(ans, mapping, digits, index, output);
        return ans;       
    }
}