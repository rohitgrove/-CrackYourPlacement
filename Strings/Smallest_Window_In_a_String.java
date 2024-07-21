import java.util.HashMap;

public class Smallest_Window_In_a_String {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "-1";

        HashMap<Character, Integer> mp = new HashMap<>();
        HashMap<Character, Integer> ms = new HashMap<>();
        for (char c : p.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = mp.size();
        int j = 0, mini = Integer.MAX_VALUE;
        int start = -1, end = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ms.put(c, ms.getOrDefault(c, 0) + 1);

            if (mp.containsKey(c) && ms.get(c).intValue() == mp.get(c).intValue()) {
                have++;
            }

            while (have == need) {
                if (i - j + 1 < mini) {
                    mini = i - j + 1;
                    start = j;
                    end = i;
                }

                char leftChar = s.charAt(j);
                ms.put(leftChar, ms.get(leftChar) - 1);
                if (mp.containsKey(leftChar) && ms.get(leftChar).intValue() < mp.get(leftChar).intValue()) {
                    have--;
                }
                j++;
            }
        }

        if (start == -1) {
            return "-1";
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String S = "timetopractice", P = "toc";
        System.out.println(smallestWindow(S, P));
    }
}
