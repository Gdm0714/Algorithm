import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        long result = 0;
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            int[] cur = {height, 1};
            while (!stack.isEmpty() && stack.peek()[0] <= height) {
                int[] top = stack.pop();
                result += top[1];

                if (top[0] == height) cur[1] += top[1];
            }

            if (!stack.isEmpty()) {
                result++;
            }

            stack.push(cur);
        }
        System.out.println(result);
    }
}
