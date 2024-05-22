import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    static int n, m;
    static ArrayList<Node>[] list;
    static int[] min;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        min = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(min, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        calculate(start);

        System.out.println(min[end]);
    }

    static void calculate(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        min[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cur = node.end;

            if (visited[cur]) continue;
            visited[cur] = true;

            for (Node nextNode : list[cur]) {
                if (min[nextNode.end] > min[cur] + nextNode.weight) {
                    min[nextNode.end] = min[cur] + nextNode.weight;
                    queue.add(new Node(nextNode.end, min[nextNode.end]));
                }
            }
        }
    }
}