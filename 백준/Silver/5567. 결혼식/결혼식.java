import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> friends = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            friends.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends.get(a).add(b);
            friends.get(b).add(a);
        }
        System.out.println(bfs(1));
    }

    static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int s = p[0];
            int dis = p[1];

            if (dis > 2) continue;

            if (dis > 0) cnt++;
            
            for (int friend : friends.get(s)) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    queue.add(new int[]{friend, dis + 1});
                }
            }
        }

        return cnt;
    }
}
