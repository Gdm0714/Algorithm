import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static boolean[] visited;
    static int max = 0;
    static int maxIndex = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());

        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) break;
                int distance = Integer.parseInt(st.nextToken());
                list.get(node).add(new Node(next, distance));
            }
        }

        visited = new boolean[v + 1];
        dfs(1, 0);
        visited = new boolean[v + 1];
        max = 0;
        dfs(maxIndex, 0);
        System.out.println(max);
    }

    static void dfs(int node, int distance){
        visited[node] = true;
        if (max < distance) {
            max = distance;
            maxIndex = node;
        }

        for (Node n : list.get(node)) {
            if (!visited[n.index]) {
                dfs(n.index, distance + n.distance);
            }
        }
    }

    static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}