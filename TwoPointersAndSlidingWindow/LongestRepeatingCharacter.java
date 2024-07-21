public class LongestRepeatingCharacter {
    public static int characterReplacement(String s, int k) {
        int m = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            m = Math.max(m, longestChainCharacter(s, k, c));
        }
        return m;
    }

    public static int longestChainCharacter(String s, int k, Character c) {
        int a = 0;
        int f = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                k--;
            }
            while (k < 0) {
                if (s.charAt(f++) != c) {
                    k++;
                }
            }
            a = Math.max(a, i - f + 1);
        }
        return a;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }
}
