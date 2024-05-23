import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][k+1];
        int mod = 1000000000;

        for (int i = 0; i <= n; i++) {
            dp[i][1] = 1;
        }

        for (int i = 0; i <= k; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int l = 0; l <= i; l++) {
                    dp[i][j] = (dp[i][j] + dp[i - l][j - 1]) % mod;
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}