package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CorrectParentheses {
    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();

        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (c[i] == '(') stack.push(c[i]);
            else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (stack.isEmpty()) return "YES";
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }
}
