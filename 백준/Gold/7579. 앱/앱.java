import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] memory = new int[n+1];
        int[] cost = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n+1][10001];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 10000; j++) {
                if (cost[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]] + memory[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for (int j = 0; j <= 10000; j++) {
            if (dp[n][j] >= m) {
                System.out.println(j);
                break;
            }
        }
    }
}