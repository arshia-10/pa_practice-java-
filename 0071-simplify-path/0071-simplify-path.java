class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] p = path.split("/");

        for (String part : p) {
            if (part.equals("") || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(part);
            }
        }

        StringBuilder res = new StringBuilder();
        for (String f : stack) {
            res.append("/");
            res.append(f);
        }

        if (res.length() == 0) {
            return "/";
        }
        return res.toString();
    }
}