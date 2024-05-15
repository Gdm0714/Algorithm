
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int num = 0;
            int x = 0, y = 0;
            int idx = 0;
            while (num++ < (n * n)) {
                arr[x][y] = num;
                x += dx[idx];
                y += dy[idx];
                if (x >= n || y >= n || x < 0 || y < 0 || arr[x][y] != 0) {
                    x -= dx[idx];
                    y -= dy[idx];
                    idx = (idx + 1) % 4;
                    x += dx[idx];
                    y += dy[idx];
                }
            }
            System.out.println("#" + (i + 1));
            for (int[] j : arr) {
                for (int k : j) System.out.print(k + " ");
                System.out.println();
            }
        }
    }
}
