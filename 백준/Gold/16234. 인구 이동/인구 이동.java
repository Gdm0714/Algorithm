import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, l, r;
    static int[][] country;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<int[]> list;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        country = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                country[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean b;
        int result = 0;

        while (true) {
            visited = new boolean[n][n];
            b = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        list = new ArrayList<>();
                        bfs(i, j);
                        if (list.size() > 1) {
                            b = true;
                            int avg = sum / list.size();
                            for (int[] num : list) {
                                country[num[0]][num[1]] = avg;
                            }
                        }
                    }
                }
            }
            if (!b) break;
            result++;
        }
        System.out.println(result);
    }

    static void bfs(int start, int end) {
        sum = country[start][end];
        queue.add(new int[]{start, end});
        visited[start][end] = true;
        list.add(new int[]{start, end});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    int mi = Math.abs(country[nx][ny] - country[point[0]][point[1]]);
                    if (mi >= l && mi <= r) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        list.add(new int[]{nx, ny});
                        sum += country[nx][ny];
                    }
                }
            }
        }
    }
}