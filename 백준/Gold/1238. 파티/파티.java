import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static List<List<Node>> graph;
    static int[] dist;
    static final int INF = (int)1e9;

    static class Node implements Comparable<Node> {
        int index, distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, time));
        }
        int[] go = new int[N+1];
        int[] back = new int[N+1];
        for (int i = 1; i <= N; i++) {
            go[i] = dijkstra(i, X);
            back[i] = dijkstra(X, i);
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, go[i] + back[i]);
        }
        System.out.println(max);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;
            int distance = node.distance;
            if (dist[now] < distance) continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = dist[now] + graph.get(now).get(i).distance;
                if (cost < dist[graph.get(now).get(i).index]) {
                    dist[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
        return dist[end];
    }
}