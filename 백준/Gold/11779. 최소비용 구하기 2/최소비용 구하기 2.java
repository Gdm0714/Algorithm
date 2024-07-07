import java.io.*;
import java.util.*;

public class Main {
    static int INF = (int)1e9;
    static int[] dist, prev;
    static List<Edge>[] adj;

    static class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        dist = new int[n+1];
        prev = new int[n+1];
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        Arrays.fill(dist, INF);
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[from].add(new Edge(to, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        ArrayList<Integer> path = new ArrayList<>();
        for (int v = end; v != 0; v = prev[v]) {
            path.add(v);
        }
        Collections.reverse(path);
        System.out.println(dist[end]);
        System.out.println(path.size());
        for (int v : path) {
            System.out.print(v + " ");
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.to;
            int cost = edge.cost;
            if (cost > dist[v]) continue;
            for (Edge e : adj[v]) {
                int nextCost = dist[v] + e.cost;
                if (nextCost < dist[e.to]) {
                    dist[e.to] = nextCost;
                    prev[e.to] = v;
                    pq.offer(new Edge(e.to, nextCost));
                }
            }
        }
    }
}