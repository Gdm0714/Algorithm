import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final int MOD = 1000000000;
    static int n;
    static Long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Long[n + 1][10][1 << 10];

        long result = 0;

        for (int i = 1; i < 10; i++) {
            result += stairnumber(n, i, 1 << i);
        }

        System.out.println(result % MOD);
    }

    static long stairnumber(int length, int digit, int visited) {
        if (length == 1) {
            if (visited == (1 << 10) - 1) { // 모든 숫자가 등장하면 1111111111
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[length][digit][visited] != null) {
            return dp[length][digit][visited];
        }

        long result = 0;

        if (digit - 1 >= 0) {
            result += stairnumber(length - 1, digit - 1, visited | (1 << (digit - 1)));
        }

        if (digit + 1 <= 9) {
            result += stairnumber(length - 1, digit + 1, visited | (1 << (digit + 1)));
        }

        return dp[length][digit][visited] = result % MOD;
    }
}