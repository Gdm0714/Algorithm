import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int h, w;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] keys;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h + 2][w + 2];
            for (int i = 1; i <= h; i++) {
                String line = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = line.charAt(j - 1);
                }
            }

            keys = new boolean[26];
            String keyLine = br.readLine();
            if (!keyLine.equals("0")) {
                for (char key : keyLine.toCharArray()) {
                    keys[key - 'a'] = true;
                }
            }

            System.out.println(bfs());
        }
    }

    static int bfs() {
        visited = new boolean[h + 2][w + 2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int documents = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2 || visited[nx][ny] || map[nx][ny] == '*') {
                    continue;
                }

                visited[nx][ny] = true;

                if (map[nx][ny] == '$') {
                    documents++;
                    map[nx][ny] = '.';
                } else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
                    if (!keys[map[nx][ny] - 'A']) {
                        continue;
                    }
                    map[nx][ny] = '.';
                } else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
                    keys[map[nx][ny] - 'a'] = true;
                    map[nx][ny] = '.';
                    visited = new boolean[h + 2][w + 2];
                    queue.clear();
                }

                queue.offer(new int[]{nx, ny});
            }
        }

        return documents;
    }
}