import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            int[][] moneys = new int[n][2];

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                moneys[j][0] = Integer.parseInt(st.nextToken());
                moneys[j][1] = Integer.parseInt(st.nextToken());
                sum += moneys[j][0] * moneys[j][1];
            }

            if (sum % 2 != 0) {
                sb.append("0\n");
                continue;
            }

            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;

            for (int[] money : moneys) {
                int value = money[0];
                int count = money[1];

                for (int j = sum / 2; j >= 0; j--) {
                    if (!dp[j]) continue;

                    for (int k = 1; k <= count && j + value * k <= sum / 2; k++) {
                        dp[j + value * k] = true;
                    }
                }
            }
            sb.append(dp[sum / 2] ? "1\n" : "0\n");
        }
        System.out.println(sb);
    }
}
