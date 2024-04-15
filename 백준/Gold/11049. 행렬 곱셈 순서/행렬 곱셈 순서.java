import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] matrix = new int[n + 1][2];
        int[] c = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                int k = i + j;
                dp[j][k] = Integer.MAX_VALUE;
                for (int l = j; l < k; l++) {
                    dp[j][k] = Math.min(dp[j][k], dp[j][l] + dp[l + 1][k] + matrix[j][0] * matrix[l][1] * matrix[k][1]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}