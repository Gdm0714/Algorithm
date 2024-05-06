import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[] visited;
    static ArrayList<int[]>[] list;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        max = 0;
        max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[p].add(new int[]{c, w});
            list[c].add(new int[]{p, w});
        }
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(max);
    }

    static void dfs(int start, int value) {
        for (int[] i : list[start]) {
            if (!visited[i[0]]) {
                visited[i[0]] = true;
                dfs(i[0], value + i[1]);
            }
        }
        max = Math.max(max, value);
    }
}