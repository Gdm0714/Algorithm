
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] d;
    static boolean[] c;

    static boolean dfs(int x) {
        for (int y : adj[x]) {
            if (c[y]) continue;
            c[y] = true;
            if (d[y] == 0 || dfs(d[y])) {
                d[y] = x;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int count = 0;
        d = new int[M+1];
        for (int i = 1; i <= N; i++) {
            c = new boolean[M+1];
            if (dfs(i)) count++;
        }

        System.out.println(count);
    }
}
