import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[][] parent;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        max = (int) Math.ceil(Math.log(n) / Math.log(2));

        tree = new ArrayList[n + 1];
        depth = new int[n + 1];
        parent = new int[n + 1][max + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1, 1);

        fillParent();

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(lca(a, b) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int node, int level) {
        depth[node] = level;

        for (int child : tree[node]) {
            if (depth[child] == 0) {
                parent[child][0] = node;
                dfs(child, level + 1);
            }
        }
    }

    static void fillParent() {
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= n; j++) {
                parent[j][i] = parent[parent[j][i-1]][i-1];
            }
        }
    }

    static int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = max; i >= 0; i--) {
            if (depth[b] - depth[a] >= (1 << i)) {
                b = parent[b][i];
            }
        }

        if (a == b) return a;

        for (int i = max; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }
}
