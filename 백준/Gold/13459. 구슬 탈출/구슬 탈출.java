import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class State {
        int rx, ry;
        int bx, by;
        int count;

        State(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m][n][m];

        int rx = 0, ry = 0, bx = 0, by = 0;

        // 보드 상태 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.count >= 10) break;

            for (int dir = 0; dir < 4; dir++) {
                int[] blue = move(cur.bx, cur.by, dir);
                if (board[blue[0]][blue[1]] == 'O') continue;

                int[] red = move(cur.rx, cur.ry, dir);
                if (board[red[0]][red[1]] == 'O') return 1;

                if (red[0] == blue[0] && red[1] == blue[1]) {
                    int redDist = Math.abs(red[0] - cur.rx) + Math.abs(red[1] - cur.ry);
                    int blueDist = Math.abs(blue[0] - cur.bx) + Math.abs(blue[1] - cur.by);

                    if (redDist > blueDist) {
                        red[0] -= dx[dir];
                        red[1] -= dy[dir];
                    } else {
                        blue[0] -= dx[dir];
                        blue[1] -= dy[dir];
                    }
                }

                if (visited[red[0]][red[1]][blue[0]][blue[1]]) continue;

                visited[red[0]][red[1]][blue[0]][blue[1]] = true;
                queue.add(new State(red[0], red[1], blue[0], blue[1], cur.count + 1));
            }
        }

        return 0;
    }

    static int[] move(int x, int y, int dir) {
        int nx = x;
        int ny = y;

        while (true) {
            nx += dx[dir];
            ny += dy[dir];

            if (board[nx][ny] == '#') {
                return new int[]{nx - dx[dir], ny - dy[dir]};
            }

            if (board[nx][ny] == 'O') {
                return new int[]{nx, ny};
            }
        }
    }
}
