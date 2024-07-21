import java.util.Stack;

public class BasicCalculator2 {
    public static int calculate(String str) {
        Stack<Integer> nums = new Stack<>();
        int num = 0;
        char sign = '+';
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == str.length() - 1) {
                if (sign == '+') {
                    nums.push(num);
                } else if (sign == '-') {
                    nums.push(-num);
                } else if (sign == '*') {
                    int top = nums.pop();
                    nums.push(top * num);
                } else if (sign == '/') {
                    int top = nums.pop();
                    nums.push(top / num);
                }
                sign = c;
                num = 0;
            }
        }

        int result = 0;
        while (!nums.isEmpty()) {
            result += nums.pop();
        }
        
        return result;
    }

    public static void main(String[] args) {
        String str1 = "3+2*2";
        System.out.println(calculate(str1));
        String str2 = " 3/2 ";
        System.out.println(calculate(str2));
        String str3 = " 3+5 / 2 ";
        System.out.println(calculate(str3));
    }
}
