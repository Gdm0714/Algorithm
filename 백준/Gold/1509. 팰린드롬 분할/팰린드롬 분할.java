
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] c = s.toCharArray();
        int[][] dp = new int[c.length + 1][c.length + 1];

        for (int i = 1; i <= c.length; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i <= c.length - 1; i++) {
            if (c[i - 1] == c[i]) {
                dp[i][i + 1] = 1;
            }
        }

        for (int i = 3; i <= c.length; i++) {
            for (int j = 1; j <= c.length - i + 1; j++) {
                int n = i + j - 1;
                if (c[j - 1] == c[n - 1] && dp[j + 1][n - 1] == 1) dp[j][n] = 1;
            }
        }

        int min[] = new int[c.length + 1];

        for (int i = 1; i <= c.length; i++) {
            min[i] = -1;
            for (int j = 1; j <= i; j++) {
                if (dp[j][i] == 1) {
                    if (min[i] == -1 || min[i] > min[j - 1] + 1) {
                        min[i] = min[j - 1] + 1;
                    }
                }
            }
        }
        System.out.println(min[c.length]);
    }
}
