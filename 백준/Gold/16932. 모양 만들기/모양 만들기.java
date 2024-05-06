import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, cnt, idx, sum;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] set;
    static HashMap<Integer, Integer> size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        arr = new int[n][m];
        set = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = Integer.MIN_VALUE;
        size = new HashMap<>();
        idx = 0;
        sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    cnt = 1;
                    visited[i][j] = true;
                    dfs(i, j);
                    size.put(idx, cnt);
                    idx++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    zeroToOne(i, j);
                    max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y) {
        set[x][y] = idx;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    cnt++;
                    dfs(nx, ny);
                }
            }
        }
    }

    static void zeroToOne(int x, int y) {
        HashSet<Integer> hashSet = new HashSet<>();
        sum = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (arr[nx][ny] == 1) hashSet.add(set[nx][ny]);
            }
        }
        for (int i : hashSet) sum += size.get(i);
    }
}