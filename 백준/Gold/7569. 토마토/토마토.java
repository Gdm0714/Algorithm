import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, h;
    static int[][][] box;
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int cnt = 0;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        box = new int[h][n][m];
        visited = new boolean[h][n][m];
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    box[k][i][j] = Integer.parseInt(st.nextToken());
                    if (box[k][i][j] == 1) {
                        visited[k][i][j] = true;
                        queue.add(new int[]{k, i, j});
                    }
                }
            }
        }
        bfs();
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        if(cnt == 0) System.out.println(0);
        else System.out.println(cnt - 1);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = point[1] + dx[i];
                int ny = point[2] + dy[i];
                int nz = point[0] + dz[i];
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < m && nz < h) {
                    if (visited[nz][nx][ny] == false && box[nz][nx][ny] == 0) {
                        visited[nz][nx][ny] = true;
                        box[nz][nx][ny] = box[point[0]][point[1]][point[2]] + 1;
                        queue.add(new int[]{nz, nx, ny});
                        cnt = box[nz][nx][ny];
                    }
                }
            }

        }
    }
}