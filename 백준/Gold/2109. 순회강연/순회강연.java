import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] uni = new int[n][2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            uni[i][0] = p;
            uni[i][1] = d;
            max = Math.max(max, d);
        }

        Arrays.sort(uni, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return b[1] - a[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        int result = 0;
        for (int i = max; i > 0; i--) {
            while (idx < n && uni[idx][1] >= i) {
                pq.offer(uni[idx][0]);
                idx++;
            }
            if(!pq.isEmpty()) result += pq.poll();
        }
        System.out.println(result);
    }
}
