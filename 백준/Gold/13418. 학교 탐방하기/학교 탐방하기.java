import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int n, m;
    static ArrayList<ArrayList<int[]>> lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()) + 1;
        lists = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int isO = Integer.parseInt(st.nextToken());
            lists.get(start).add(new int[]{end, isO});
            lists.get(end).add(new int[]{start, isO});
        }

        int min = bfs(true);
        int max = bfs(false);
        System.out.println(max - min);
    }

    static int bfs(boolean b) {
        visited = new boolean[n + 1];

        PriorityQueue<int[]> q;
        if (b) {
            q = new PriorityQueue<>((a, c) -> c[1] - a[1]);
        } else {
            q = new PriorityQueue<>((a, c) -> a[1] - c[1]);
        }

        q.add(new int[]{0, -1});
        int result = 0;
        int cnt = 0;


        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int piro = cur[1];
            if (visited[node]) continue;
            visited[node] = true;
            if (piro == 0) result++;

            if (node != 0) cnt++;

            for (int i[] : lists.get(node)) {
                if (!visited[i[0]]) {
                    q.add(new int[]{i[0], i[1]});
                }
            }
        }
        return result * result;
    }
}