import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int[] cost = new int[k];
            int[] sum = new int[k + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < k; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
                sum[j + 1] = sum[j] + cost[j];
            }

            int[][] dp = new int[k][k];

            for (int l = 1; l < k; l++) {
                for (int q = 0; q + l < k; q++) {
                    int end = q + l;
                    dp[q][end] = Integer.MAX_VALUE;

                    for (int w = q; w < end; w++) {
                        dp[q][end] = Math.min(dp[q][end], dp[q][w] + dp[w + 1][end] + sum[end + 1] - sum[q]);
                    }
                }
            }
            System.out.println(dp[0][k - 1]);
        }
    }
}
