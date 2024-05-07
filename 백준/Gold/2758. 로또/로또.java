import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long[][] arr;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr = new long[n + 1][m + 1];
            for (int j = 0; j <= m; j++) arr[0][j] = 1;

            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    arr[j][k] = arr[j - 1][k / 2] + arr[j][k - 1];
                }
            }
            System.out.println(arr[n][m]);
        }
    }
}