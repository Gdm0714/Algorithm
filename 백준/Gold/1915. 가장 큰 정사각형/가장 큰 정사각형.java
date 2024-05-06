import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][m + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = s.charAt(j - 1) - '0';
                if (arr[i][j] == 1) {
                    int min = Math.min(Math.min(arr[i - 1][j], arr[i][j - 1]), arr[i - 1][j - 1]);
                    arr[i][j] = min + 1;
                    max = Math.max(max, arr[i][j]);
                }
            }
        }
        System.out.println(max * max);
    }
}