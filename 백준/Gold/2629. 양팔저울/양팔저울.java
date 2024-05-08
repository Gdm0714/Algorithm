import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] weights = new int[n];
        boolean[] dp = new boolean[40001];

        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            boolean[] b = new boolean[40001];
            for (int j = 0; j < 40001; j++) {
                if (dp[j]) {
                    b[j] = true;
                    b[j + weights[i]] = true;
                    b[Math.abs(j - weights[i])] = true;
                }
            }
            b[weights[i]] = true;
            dp = b;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int bead = Integer.parseInt(st.nextToken());
            sb.append(dp[bead] ? "Y " : "N ");
        }
        System.out.println(sb.toString().trim());
    }
}
