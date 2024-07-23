public class RemoveAllAdjacent2 {
    public String removeDuplicates(String s, int k) {
        StringBuilder sArr = new StringBuilder(s);
        int i = 0, j = 0;
        int count[] = new int[s.length()];
        while (j < sArr.length()) {
            sArr.setCharAt(i, sArr.charAt(j));
            count[i] = 1;
            if (i > 0 && sArr.charAt(i) == sArr.charAt(i - 1)) {
                count[i] += count[i - 1];
            }
            if (count[i] == k) {
                i -= k;
            }
            ++i;
            ++j;
        }

        return sArr.substring(0, i);
    }
}