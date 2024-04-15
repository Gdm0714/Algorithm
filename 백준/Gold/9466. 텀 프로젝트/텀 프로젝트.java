import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> arr;
    static boolean[] visited;
    static boolean[] b;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new ArrayList<>();
            visited = new boolean[n + 1];
            b = new boolean[n + 1];
            cnt = 0;
            for (int j = 0; j < n; j++) arr.add(Integer.parseInt(st.nextToken()));

            for (int j = 1; j <= n; j++) if (!visited[j]) dfs(j);
            System.out.println(n - cnt);
        }
    }

    static void dfs(int j) {
        visited[j] = true;
        int next = arr.get(j - 1);
        if (!visited[next]) dfs(next);
        else {
            if (!b[next]) {
                for (int i = next; i != j; i = arr.get(i - 1)) cnt++;
                cnt++;
            }
        }
        b[j] = true;
    }
}