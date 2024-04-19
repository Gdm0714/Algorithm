
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{rx, ry, bx, by, 0});
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            rx = current[0];
            ry = current[1];
            bx = current[2];
            by = current[3];
            int count = current[4];

            if (count > 10) {
                return -1;
            }

            if (map[rx][ry] == 'O' && map[bx][by] != 'O') {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int[] nextRed = move(rx, ry, dx[i], dy[i]);
                int[] nextBlue = move(bx, by, dx[i], dy[i]);

                if (map[nextBlue[0]][nextBlue[1]] == 'O') {
                    continue;
                }

                if (nextRed[0] == nextBlue[0] && nextRed[1] == nextBlue[1]) {
                    switch (i) {
                        case 0: // up
                            if (rx > bx) {
                                nextRed[0]++;
                            } else {
                                nextBlue[0]++;
                            }
                            break;
                        case 1: // down
                            if (rx > bx) {
                                nextBlue[0]--;
                            } else {
                                nextRed[0]--;
                            }
                            break;
                        case 2: // left
                            if (ry > by) {
                                nextRed[1]++;
                            } else {
                                nextBlue[1]++;
                            }
                            break;
                        case 3: // right
                            if (ry > by) {
                                nextBlue[1]--;
                            } else {
                                nextRed[1]--;
                            }
                            break;
                    }
                }

                if (!visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) {
                    visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
                    queue.offer(new int[]{nextRed[0], nextRed[1], nextBlue[0], nextBlue[1], count + 1});
                }
            }
        }

        return -1;
    }

    static int[] move(int x, int y, int dx, int dy) {
        int count = 0;
        while (map[x + dx][y + dy] != '#' && map[x][y] != 'O') {
            x += dx;
            y += dy;
            count++;
        }
        return new int[]{x, y, count};
    }
}