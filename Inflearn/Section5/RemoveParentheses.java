package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RemoveParentheses {
    public static String solution(String s){
        String result = "";
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(c);
            else if (c == ')') stack.pop();
            else{
                if(stack.isEmpty()) result += c;
            }
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }
}
