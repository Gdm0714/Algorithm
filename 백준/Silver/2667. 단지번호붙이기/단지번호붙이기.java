import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        int idx = 0;
        int result[] = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    result[idx++] = bfs(i, j);
                }
            }
        }
        Arrays.sort(result);
        System.out.println(idx);
        for (int i : result) {
            if (i != 0) {
                System.out.println(i);
            }
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) continue;

                if (arr[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});

                }
            }
        }
        return cnt;
    }
}


