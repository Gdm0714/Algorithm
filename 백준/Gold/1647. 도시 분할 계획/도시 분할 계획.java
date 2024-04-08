import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] parent;
    static int result = 0;
    static PriorityQueue<Node> pq = new PriorityQueue<Node>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            pq.add(new Node(h1, h2, len));
        }
        int cnt = 0;
        while (cnt < n - 2) {
            Node a = pq.poll();
            if (check(a.h1, a.h2)) {
                merge(a.h1, a.h2);
                result += a.len;
                cnt++;
            }
        }
        System.out.println(result);
    }

    public static boolean check(int v1, int v2) {
        if (find(v1) == find(v2)) {
            return false;
        }
        return true;
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void merge(int v1, int v2) {
        int x = find(v1);
        int y = find(v2);
        if (x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        parent[y] = x;
    }
}

class Node implements Comparable<Node> {
    int h1, h2, len;

    Node(int h1, int h2, int len) {
        this.h1 = h1;
        this.h2 = h2;
        this.len = len;
    }

    public int compareTo(Node o) {
        return this.len - o.len;
    }
}