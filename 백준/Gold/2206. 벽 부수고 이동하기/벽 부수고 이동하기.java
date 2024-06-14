import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][][] visited;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        bfs();
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 1});
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            if (point[0] == n - 1 && point[1] == m - 1){
                System.out.println(point[3]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 1 && point[2] == 0) {
                        visited[nx][ny][1] = point[3] + 1;
                        queue.add(new int[]{nx, ny, 1, point[3] + 1});
                    } else if (map[nx][ny] == 0 && visited[nx][ny][point[2]] == 0) {
                        visited[nx][ny][point[2]] = point[3] + 1;
                        queue.add(new int[]{nx, ny, point[2], point[3] + 1});
                    }
                }
            }
        }
        System.out.println(-1);
    }
}