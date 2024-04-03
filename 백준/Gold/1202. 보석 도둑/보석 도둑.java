import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Jew {
        int m, v;

        public Jew(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] c = new int[K];
        int m;
        int v;
        List<Jew> jews = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            jews.add(new Jew(m, v));
        }

        jews.sort((o1, o2) -> {
            if (o1.m == o2.m) return 0;
            else if (o1.m > o2.m) return 1;
            return -1;
        });


        for (int i = 0; i < K; i++) {
            c[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(c);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        int jewIdx = 0;
        for (int i = 0; i < K; i++) {
            while(jewIdx < N && c[i] >= jews.get(jewIdx).m) queue.add(jews.get(jewIdx++).v);
            if(!queue.isEmpty()) result += queue.poll();
        }
        System.out.println(result);
    }
}