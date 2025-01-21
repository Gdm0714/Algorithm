import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[][] visited;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        while (true) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 1) cnt++;
                }
            }
            if (cnt == 0) break;
            visited = new boolean[n][m];
            bfs();
            result++;
        }
        System.out.println(result);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        ArrayList<int[]> list = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;

                if (board[nx][ny] == 0) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                } else {
                    int cnt = 0;
                    for (int j = 0; j < 4; j++) {
                        int nx2 = nx + dx[j];
                        int ny2 = ny + dy[j];
                        if (nx2 >= 0 && ny2 >= 0 && nx2 < n && ny2 < m && board[nx2][ny2] == 0 && visited[nx2][ny2])
                            cnt++;
                    }
                    if (cnt >= 2) {
                        list.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        for (int[] i : list) {
            board[i[0]][i[1]] = 0;
        }
    }
}
