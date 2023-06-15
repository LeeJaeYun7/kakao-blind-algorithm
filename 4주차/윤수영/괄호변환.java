import java.util.Stack;

class Solution {
    public String solution(String p) {
        // 1단계
        if(p == null || isRightString(p)) return p;

        // 2단계
        int split = toBalancedString(p);
        String u = p.substring(0, split);
        String v = p.substring(split);

        // 3단계
        if(isRightString(u))
            return u + solution(v);

        // 4단계
        String ans = "(" + solution(v) + ")" + toReverse(u.substring(1, u.length() - 1));

        return ans;
    }

    int toBalancedString(String p){
        int left = 0;
        int right = 0;
        for (char c : p.toCharArray()) {
            if(c == '(') left++;
            if(c == ')') right++;
            if(left == right) return 2 * left;
        }
        return 0;
    }

    boolean isRightString(String str){
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if(c == '(') stack.push(c);
            if(c == ')'){
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return true;
    }

    String toReverse(String str){
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append((c == '(') ? ')' : '(');
        }
        return sb.toString();
    }
}
