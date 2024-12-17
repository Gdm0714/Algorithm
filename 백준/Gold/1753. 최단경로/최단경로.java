import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{k, 0});
        int[] d = new int[V + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[k] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curV = cur[0];
            int curW = cur[1];
            
            for (int[] nextV : list.get(curV)) {
                int nextD = d[curV] + nextV[1];
                if (nextD < d[nextV[0]]) {
                    d[nextV[0]] = nextD;
                    pq.add(new int[]{nextV[0], nextD});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (d[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(d[i]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
