import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, r;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        int root = 0;
        for (int i = 0; i < n; i++) {
            int pa = Integer.parseInt(st.nextToken());
            if (pa == -1) root = i;
            else tree[pa].add(i);
        }
        r = Integer.parseInt(br.readLine());
        visited[r] = true;

        if (r == root) System.out.println(0);
        else System.out.println(dfs(root));
    }

    static int dfs(int node) {
        if (visited[node]) return 0;
        int cnt = 0;
        for (int c : tree[node]) cnt += dfs(c);
        if (cnt == 0) return 1;
        return cnt;
    }
}