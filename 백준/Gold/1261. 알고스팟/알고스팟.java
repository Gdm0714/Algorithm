import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});
        int[][] min = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                min[i][j] = Integer.MAX_VALUE;
            }
        }
        min[0][0] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int w = cur[2];

            if (x == n - 1 && y == m - 1) return w;

            if (min[x][y] < w) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                int num = w;
                if (map[nx][ny] == 1) num++;
                if (min[nx][ny] > num) {
                    min[nx][ny] = num;
                    if (map[nx][ny] == 0) {
                        q.addFirst(new int[]{nx, ny, num});
                    } else {
                        q.addLast(new int[]{nx, ny, num});
                    }
                }

            }
        }

        return min[n - 1][m - 1];
    }
}