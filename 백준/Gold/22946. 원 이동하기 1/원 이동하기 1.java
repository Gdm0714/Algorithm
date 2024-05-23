import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Circle[] circles;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int max = 0;
    static int start = 0;

    static class Circle {
        int x, y, r;

        Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        circles = new Circle[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            circles[i] = new Circle(x, y, r);
        }
        circles[n] = new Circle(0, 0, Integer.MAX_VALUE);
        Arrays.sort(circles, (a, b) -> b.r - a.r);
        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        visited = new boolean[n + 1];

        isInside(0);

        Arrays.fill(visited, false);
        visited[0] = true;
        dfsDepth(0, 0);

        Arrays.fill(visited, false);
        dfsDepth(0, start);

        System.out.println(max);
    }

    static void isInside(int cur) {
        Circle c1 = circles[cur];
        for (int i = cur + 1; i <= n; i++) {
            if (!visited[i]) {
                Circle c2 = circles[i];
                double d = Math.sqrt(Math.pow(c1.x - c2.x, 2) + Math.pow(c1.y - c2.y, 2));
                if (d < c1.r) {
                    graph[cur].add(i);
                    graph[i].add(cur);
                    visited[i] = true;
                    isInside(i);
                }
            }
        }
    }

    static void dfsDepth(int depth, int cur) {
        if (depth > max) {
            max = depth;
            start = cur;
        }
        for (int next : graph[cur]) {
            if (!visited[next]) {
                visited[next] = true;
                dfsDepth(depth + 1, next);
                visited[next] = false;
            }
        }
    }
}