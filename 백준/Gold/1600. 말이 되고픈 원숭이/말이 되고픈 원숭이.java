import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int k, w, h;
    static int[][] map;
    static int[][][] visited;
    static int[] dx = {-1, 1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {0, 0, -1, 1, -1, -2, -2, -1, 1, 2, 2, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        visited = new int[h][w][k + 1];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {

        queue.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dk = current[2];
            int count = current[3];

            if (x == h - 1 && y == w - 1) return count;

            for (int i = 0; i < 12; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (map[nx][ny] == 1) continue;

                if (i < 4) {
                    if (visited[nx][ny][dk] == 0) {
                        visited[nx][ny][dk] = 1;
                        queue.offer(new int[]{nx, ny, dk, count + 1});
                    }
                } else {
                    if (dk < k && visited[nx][ny][dk + 1] == 0) {
                        visited[nx][ny][dk + 1] = 1;
                        queue.offer(new int[]{nx, ny, dk + 1, count + 1});
                    }
                }
            }
        }

        return -1;
    }
}