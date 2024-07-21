import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

public class PrintAnagrams {
    public static List<List<String>> Anagrams(String[] s) {
        int n = s.length;
        List<List<String>> ans = new ArrayList<>();

        HashMap<String, List<String>> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char[] tempArray = s[i].toCharArray();
            Arrays.sort(tempArray);
            String temp = new String(tempArray);
            if (!m.containsKey(temp)) {
                m.put(temp, new ArrayList<>());
            }
            m.get(temp).add(s[i]);
        }

        for (Map.Entry<String, List<String>> entry : m.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        String words[] = { "act", "god", "cat", "dog", "tac" };
        System.out.println(Anagrams(words));
    }
}
