import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
            lists[i].add(0);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[b].add(a);
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j : lists[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            System.out.print(dp[i] + " ");
        }
    }
}