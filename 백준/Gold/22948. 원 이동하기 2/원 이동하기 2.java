import java.io.*;
import java.util.*;

public class Main {
    static int N, A, B;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    static ArrayList<Circle> circles = new ArrayList<>();

    static class Circle implements Comparable<Circle> {
        int k, x;

        Circle(int k, int x) {
            this.k = k;
            this.x = x;
        }

        @Override
        public int compareTo(Circle o) {
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            circles.add(new Circle(k, x - r));
            circles.add(new Circle(-k, x + r));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        Collections.sort(circles);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        makeTree(stack);
        visited[A] = true;
        dfs(A, new ArrayList<>(Arrays.asList(A)));
    }

    static void makeTree(Stack<Integer> stack) {
        for (Circle circle : circles) {
            if (circle.k < 0) stack.pop();
            else {
                int parent = stack.peek();
                tree[parent].add(circle.k);
                tree[circle.k].add(parent);
                stack.push(circle.k);
            }
        }
    }

    static void dfs(int cur, ArrayList<Integer> path) {
        if (cur == B) {
            System.out.println(path.size());
            for (int i : path) System.out.print(i + " ");
        } else {
            for (int next : tree[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    ArrayList<Integer> newPath = new ArrayList<>(path);
                    newPath.add(next);
                    dfs(next, newPath);
                    visited[next] = false;
                }
            }
        }
    }
}