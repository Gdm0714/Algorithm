import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] towers = new int[n];
        for (int i = 0; i < n; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] receiver = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                receiver[i] = 0;
            } else {
                receiver[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(receiver[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}