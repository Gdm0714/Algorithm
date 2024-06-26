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
        int[] men = new int[n + 1];
        int[] women = new int[m + 1];
        long[][] dp = new long[n + 1][m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) men[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) women[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(men);
        Arrays.sort(women);


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j - 1] + Math.abs(men[i] - women[j]);
                if (i > j) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                } else if (i < j) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}