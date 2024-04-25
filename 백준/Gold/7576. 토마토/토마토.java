import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] box;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int cnt = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        if(cnt == 0) System.out.println(0);
        else System.out.println(cnt - 1);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] po = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = po[0] + dx[i];
                int ny = po[1] + dy[i];
                if (nx < n && ny < m && nx >= 0 && ny >= 0) {
                    if (!visited[nx][ny] && box[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        box[nx][ny] = box[po[0]][po[1]] + 1;
                        cnt = box[nx][ny];
                    }
                }
            }
        }
    }
}