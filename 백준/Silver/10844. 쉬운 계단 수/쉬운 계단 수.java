import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        long[][] dp = new long[N+1][10];
        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j+1];
                } else if (j == 9) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }

        long total = 0;
        for (int j = 0; j <= 9; j++) {
            total = (total + dp[N][j]) % 1000000000;
        }

        System.out.println(total);
    }
}