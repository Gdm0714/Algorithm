import java.io.*;
import java.util.*;

public class Main {
    static class Mineral implements Comparable<Mineral> {
        int x, y, v;

        Mineral(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }

        @Override
        public int compareTo(Mineral o) {
            if (this.x == o.x) return this.y - o.y;
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Mineral[] minerals = new Mineral[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            minerals[i] = new Mineral(x, y, v);
        }

        Arrays.sort(minerals);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            pq.add(minerals[i].v);
            sum += minerals[i].v;
            while (pq.size() > c) {
                sum -= pq.poll();
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
