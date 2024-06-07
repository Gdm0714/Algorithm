import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n + 2];
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        long maxArea = 0;
        for (int i = 1; i <= n + 1; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                long height = arr[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        System.out.println(maxArea);
    }
}