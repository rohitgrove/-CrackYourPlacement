import java.util.Stack;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        Stack<String> st = new Stack<>();
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                if (i != words.length - 1) {
                    st.push(" " + words[i]);                    
                } else {
                    st.push(words[i]);   
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.append(st.pop());
        }
        return String.valueOf(sb);
    }
    public static void main(String[] args) {
        String str1 = "the sky is blue";
        System.out.println(reverseWords(str1));
        String str2 = "  hello world  ";
        System.out.println(reverseWords(str2));
        String str3 = "a good   example";
        System.out.println(reverseWords(str3));
    }    
}
