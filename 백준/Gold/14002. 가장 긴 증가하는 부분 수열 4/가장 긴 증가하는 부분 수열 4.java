import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] pre = new int[n];
        int max = Integer.MIN_VALUE;
        int maxIdx = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            pre[i] = i;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    pre[i] = j;
                    dp[i] = dp[j] + 1;
                }
            }
            maxIdx = max < dp[i] ? i : maxIdx;
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        ArrayList<Integer> lis = new ArrayList<>();
        while (lis.size() < max) {
            lis.add(0, arr[maxIdx]);
            maxIdx = pre[maxIdx];
        }

        StringBuilder sb = new StringBuilder();
        for (int num : lis) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}