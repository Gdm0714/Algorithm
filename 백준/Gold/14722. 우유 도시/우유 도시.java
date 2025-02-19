import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        int result = dfs(0, 0, 2);
        System.out.println(result);

    }

    static int dfs(int x, int y, int last) {
        if (x >= n || y >= n) return 0;

        if (dp[x][y][last] != -1) return dp[x][y][last];

        int result = 0;

        int a = Math.max(dfs(x + 1, y, last), dfs(x, y + 1, last));

        int next = (last + 1) % 3;
        if(map[x][y] == next) {
            int b = 1 + Math.max(dfs(x + 1, y, next), dfs(x, y + 1, next));
            result = Math.max(a, b);
        }else{
            result = a;
        }

        return dp[x][y][last] = result;
    }
}
