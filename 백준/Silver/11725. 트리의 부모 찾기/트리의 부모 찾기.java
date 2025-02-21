import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> lists;
    static int[] parents;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];
        parents = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    static void dfs(int start) {
        visited[start] = true;
        for (int i : lists.get(start)) {
            if (!visited[i]) {
                parents[i] = start;
                dfs(i);
            }
        }
    }
}