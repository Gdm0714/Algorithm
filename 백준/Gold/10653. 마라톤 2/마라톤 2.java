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
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        dp[0][0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= Math.min(k, i - 1); j++) {
                for (int skip = 0; skip <= Math.min(k - j, i - 1); skip++) {
                    int prev = i - skip - 1;
                    if (prev >= 0 && dp[prev][j] != Integer.MAX_VALUE) {
                        int dist = Math.abs(arr[i][0] - arr[prev][0]) + Math.abs(arr[i][1] - arr[prev][1]);
                        dp[i][j + skip] = Math.min(dp[i][j + skip], dp[prev][j] + dist);
                    }
                }
            }
        }

        System.out.println(dp[n - 1][k]);
    }
}