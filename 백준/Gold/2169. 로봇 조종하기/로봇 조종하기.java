import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[N][M];
        
        dp[0][0] = map[0][0];
        for (int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j-1] + map[0][j];
        }
        
        for (int i = 1; i < N; i++) {
            int[] rightToLeft = new int[M];
            rightToLeft[0] = dp[i-1][0] + map[i][0];
            for (int j = 1; j < M; j++) {
                rightToLeft[j] = Math.max(dp[i-1][j], rightToLeft[j-1]) + map[i][j];
            }
            
            int[] leftToRight = new int[M];
            leftToRight[M-1] = dp[i-1][M-1] + map[i][M-1];
            for (int j = M-2; j >= 0; j--) {
                leftToRight[j] = Math.max(dp[i-1][j], leftToRight[j+1]) + map[i][j];
            }
            
            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(rightToLeft[j], leftToRight[j]);
            }
        }
        
        System.out.println(dp[N-1][M-1]);
    }
}