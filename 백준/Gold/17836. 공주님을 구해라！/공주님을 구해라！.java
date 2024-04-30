import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, t;
    static int[][] castle;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        castle = new int[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = bfs();
        if (result == -1) System.out.println("Fail");
        else System.out.println(result);
    }

    static int bfs() {
        queue.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int result = point[3];
            int g = point[2];
            if (result > t) break;


            if (point[0] == n - 1 && point[1] == m - 1) return result;

            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (g == 0) {
                        if (castle[nx][ny] == 0 && !visited[nx][ny][0]) {
                            queue.add(new int[]{nx, ny, g, result + 1});

                        } else if (castle[nx][ny] == 2 && !visited[nx][ny][0]) {
                            queue.add(new int[]{nx, ny, g + 1, result + 1});

                        }
                        visited[nx][ny][0] = true;
                    } else if (g == 1) {
                        if (!visited[nx][ny][1]) {
                            queue.add(new int[]{nx, ny, g, result + 1});
                        }
                        visited[nx][ny][1] = true;

                    }
                }
            }
        }
        return -1;
    }
}