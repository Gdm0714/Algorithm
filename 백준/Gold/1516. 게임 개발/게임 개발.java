import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N+1];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) break;
                adj.get(x).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N+1];
        for (int i = 1; i <= N; i++) {
            result[i] = time[i];
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : adj.get(now)) {
                result[next] = Math.max(result[next], result[now] + time[next]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }
}