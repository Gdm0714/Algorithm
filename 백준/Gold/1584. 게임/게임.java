import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited = new boolean[501][501];
    static int[][] map = new int[501][501];
    static int[][] dist = new int[501][501];
    static PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i[] : dist) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int a = Math.max(x1, x2);
            int b = Math.min(x1, x2);
            int c = Math.max(y1, y2);
            int d = Math.min(y1, y2);
            for (int j = b; j <= a; j++) {
                for (int k = d; k <= c; k++) {
                    map[j][k] = 1;
                }
            }
        }


        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int a = Math.max(x1, x2);
            int b = Math.min(x1, x2);
            int c = Math.max(y1, y2);
            int d = Math.min(y1, y2);
            for (int j = b; j <= a; j++) {
                for (int k = d; k <= c; k++) {
                    map[j][k] = 2;
                }
            }
        }
        bfs();
        if (n == 0 && m == 0) {
            System.out.println(0);
            return;
        }
        int result = dist[500][500] == Integer.MAX_VALUE ? -1 : dist[500][500];
        System.out.println(result);
    }

    static void bfs() {
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx <= 500 && ny <= 500 && nx >= 0 && ny >= 0) {
                    if (!visited[nx][ny] && map[nx][ny] != 2) {
                        if (map[nx][ny] == 1) {
                            int next = dist[cur[0]][cur[1]] + map[nx][ny];
                            if (dist[nx][ny] > next) {
                                dist[nx][ny] = next;
                                pq.add(new int[]{nx, ny, next});
                            }
                        } else if (map[nx][ny] == 0) {
                            dist[nx][ny] = dist[cur[0]][cur[1]];
                            pq.add(new int[]{nx, ny, dist[nx][ny]});
                        }
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}