import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int tmp = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                tmp *= 2;
                stack.push(c);
            } else if (c == '[') {
                tmp *= 3;
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }

                if (s.charAt(i - 1) == '(') result += tmp;
                stack.pop();
                tmp /= 2;

            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                if (s.charAt(i - 1) == '[') result += tmp;
                stack.pop();
                tmp /= 3;
            }
        }
        if (!stack.isEmpty()) result = 0;
        System.out.println(result);
    }
}
