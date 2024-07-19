import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("") || token.equals(".")) {
                continue;
            }
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String path1 = "/home/";
        System.out.println(simplifyPath(path1));
        String path2 = "/home//foo/";
        System.out.println(simplifyPath(path2));
        String path3 = "/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(path3));
        String path4 = "/../";
        System.out.println(simplifyPath(path4));
        String path5 = "/.../a/../b/c/../d/./";
        System.out.println(simplifyPath(path5));
    }
}
