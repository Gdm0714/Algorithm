import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lists = new ArrayList[n];
        result = 0;

        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, 0);
            if (result == 1) break;
        }

        System.out.println(result);
    }

    static void dfs(int i, int idx) {
        if (idx == 4) {
            result = 1;
            return;
        }
        visited[i] = true;

        for (int j : lists[i]) {
            if (!visited[j]) {
                dfs(j, idx + 1);
                if (result == 1) return;
            }
        }
        visited[i] = false;
    }
}