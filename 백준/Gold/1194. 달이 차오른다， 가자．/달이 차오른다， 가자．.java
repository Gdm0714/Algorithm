import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] maze;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y, keys, dist;

        Point(int x, int y, int keys, int dist) {
            this.x = x;
            this.y = y;
            this.keys = keys;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new char[n][m];
        visited = new boolean[n][m][64];

        int startX = 0, startY = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j);
                if (maze[i][j] == '0') {
                    startX = i;
                    startY = j;
                    maze[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(startX, startY));
    }

    static int bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY, 0, 0));
        visited[startX][startY][0] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (maze[cur.x][cur.y] == '1') {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nKeys = cur.keys;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (maze[nx][ny] == '#') continue;

                if (maze[nx][ny] >= 'a' && maze[nx][ny] <= 'f') {
                    nKeys |= (1 << (maze[nx][ny] - 'a'));
                }

                if (maze[nx][ny] >= 'A' && maze[nx][ny] <= 'F') {
                    if ((nKeys & (1 << (maze[nx][ny] - 'A'))) == 0) continue;
                }

                if (visited[nx][ny][nKeys]) continue;

                visited[nx][ny][nKeys] = true;
                queue.offer(new Point(nx, ny, nKeys, cur.dist + 1));
            }
        }

        return -1;
    }
}
