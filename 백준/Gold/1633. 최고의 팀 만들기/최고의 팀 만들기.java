import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> white = new ArrayList<>();
    static ArrayList<Integer> black = new ArrayList<>();
    static int[][][] dp;
    static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            white.add(Integer.parseInt(st.nextToken()));
            black.add(Integer.parseInt(st.nextToken()));
            n++;
        }

        dp = new int[n][16][16];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 16; j++) {
                for (int k = 0; k < 16; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        System.out.println(solve(0, 0, 0));
    }

    static int solve(int idx, int w, int b) {
        if (idx == n || (w == 15 && b == 15)) return 0;
        if (dp[idx][w][b] != -1) return dp[idx][w][b];

        int result = solve(idx + 1, w, b);

        if (w < 15) result = Math.max(result, solve(idx + 1, w + 1, b) + white.get(idx));
        if (b < 15) result = Math.max(result, solve(idx + 1, w, b + 1) + black.get(idx));

        return dp[idx][w][b] = result;
    }
}