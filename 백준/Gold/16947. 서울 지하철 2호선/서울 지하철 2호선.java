import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] d;
    static boolean[] visited;
    static boolean[] cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        d = new int[n + 1];
        visited = new boolean[n + 1];
        cycle = new boolean[n + 1];

        dfs(1, 0);

        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(d, -1);

        for (int i = 1; i <= n; i++) {
            if (cycle[i]) {
                q.add(i);
                d[i] = 0;
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                if (d[next] == -1) {
                    q.add(next);
                    d[next] = d[now] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(d[i]).append(" ");
        }
        System.out.println(sb);
    }

    static int dfs(int x, int prev) {
        if (visited[x]) return x;
        visited[x] = true;

        for (int y : list[x]) {
            if (y == prev) continue;
            int res = dfs(y, x);
            if (res == -2) return -2;
            if (res >= 0) {
                cycle[x] = true;
                if (x == res) return -2;
                return res;
            }
        }
        return -1;
    }
}