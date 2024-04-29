import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] time;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        time = new int[100001];
        bfs();
        System.out.println(time[k]);
    }

    static void bfs() {
        queue.add(n);
        visited[n] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == k) break;
            if ((2 * x) <= 100000 && !visited[2 * x]) {
                queue.add(2 * x);
                time[2 * x] = time[x];
                visited[2 * x] = true;
            }
            if ((x - 1) >= 0 && !visited[x - 1]) {
                queue.add(x - 1);
                time[x - 1] = time[x] + 1;
                visited[x - 1] = true;
            }
            if ((x + 1) <= 100000 && !visited[x + 1]) {
                queue.add(x + 1);
                time[x + 1] = time[x] + 1;
                visited[x + 1] = true;
            }
        }
    }
}