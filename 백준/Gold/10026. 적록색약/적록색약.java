import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, result1, result2;
    static Queue<int[]> queue = new LinkedList<>();
    static char[][] print;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        print = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) print[i] = br.readLine().toCharArray();

        result1 = 0;
        result2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, false);
                    result1++;
                }
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, true);
                    result2++;
                }
            }
        }


        System.out.println(result1 + " " + result2);
    }

    static void bfs(int x, int y, boolean b) {
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (visited[nx][ny]) continue;
                if (b) {
                    if ((print[p[0]][p[1]] == 'R' || print[p[0]][p[1]] == 'G') && (print[nx][ny] == 'R' || print[nx][ny] == 'G')) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    } else if (print[p[0]][p[1]] == print[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                } else {
                    if (print[p[0]][p[1]] == print[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}