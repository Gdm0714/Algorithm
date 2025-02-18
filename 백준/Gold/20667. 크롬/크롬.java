import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] chrome = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            chrome[i][0] = Integer.parseInt(st.nextToken());
            chrome[i][1] = Integer.parseInt(st.nextToken());
            chrome[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[501][1001];
        for (int i = 0; i <= 500; i++) Arrays.fill(dp[i], -1);
        dp[0][0] = 0;

        for (int[] tab : chrome) {
            int cpu = tab[0];
            int memo = tab[1];
            int pr = tab[2];

            for (int p = 500 - pr; p >= 0; p--) {
                for (int c = 0; c <= m; c++) {
                    if (dp[p][c] == -1) continue;
                    int nc = Math.min(m, c + cpu);
                    int nm = dp[p][c] + memo;
                    dp[p + pr][nc] = Math.max(dp[p + pr][nc], nm);
                }
            }
        }

        int result = -1;
        for (int p = 0; p <= 500; p++) {
            for (int c = m; c <= m; c++) {
                if (dp[p][c] >= k) {
                    result = p;
                    p = 501;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}