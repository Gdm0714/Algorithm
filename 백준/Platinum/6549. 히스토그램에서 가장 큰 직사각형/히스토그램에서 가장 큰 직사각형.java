import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            long[] heights = new long[n];
            for (int i = 0; i < n; i++) {
                heights[i] = Long.parseLong(st.nextToken());
            }

            Stack<Integer> stack = new Stack<>();
            long max = 0;
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    long height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = Math.max(max, height * width);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                long height = heights[stack.pop()];
                int width = stack.isEmpty() ? n : n - stack.peek() - 1;
                max = Math.max(max, height * width);
            }

            System.out.println(max);
        }
    }
}