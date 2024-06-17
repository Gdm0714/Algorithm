import java.io.*;
import java.util.*;

public class Main {
    static int n, m, islandCount;
    static int[][] map, dist;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static class Edge implements Comparable<Edge> {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        islandCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandCount++;
                    dfs(i, j, islandCount);
                }
            }
        }
        dist = new int[islandCount + 1][islandCount + 1];
        for (int i = 1; i <= islandCount; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    bfs(i, j, map[i][j]);
                }
            }
        }
        for (int i = 2; i <= islandCount; i++) {
            if (dist[1][i] != Integer.MAX_VALUE) {
                pq.add(new Edge(i, dist[1][i]));
            }
        }
        boolean[] check = new boolean[islandCount + 1];
        check[1] = true;
        int answer = 0, cnt = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (check[edge.to]) continue;
            check[edge.to] = true;
            answer += edge.weight;
            for (int i = 1; i <= islandCount; i++) {
                if (!check[i] && dist[edge.to][i] != Integer.MAX_VALUE) {
                    pq.add(new Edge(i, dist[edge.to][i]));
                }
            }
            if (++cnt == islandCount - 1) break;
        }
        System.out.println(cnt == islandCount - 1 ? answer : -1);
    }
    static void dfs(int x, int y, int cnt) {
        visited[x][y] = true;
        map[x][y] = cnt;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 0) continue;
            dfs(nx, ny, cnt);
        }
    }
    static void bfs(int x, int y, int cnt) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i], bridge = 0;
            while (true) {
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == cnt) break;
                if (map[nx][ny] != 0 && map[nx][ny] != cnt) {
                    if (bridge > 1 && dist[cnt][map[nx][ny]] > bridge) {
                        dist[cnt][map[nx][ny]] = bridge;
                        dist[map[nx][ny]][cnt] = bridge;
                    }
                    break;
                }
                nx += dx[i];
                ny += dy[i];
                bridge++;
            }
        }
    }
}