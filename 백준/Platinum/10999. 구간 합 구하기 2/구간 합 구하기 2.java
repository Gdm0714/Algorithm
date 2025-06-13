import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long[] tree1, tree2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        tree1 = new long[N + 2];
        tree2 = new long[N + 2];

        for (int i = 1; i <= N; i++) {
            long val = Long.parseLong(br.readLine());
            rangeUpdate(i, i, val);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());
                rangeUpdate(b, c, d);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(rangeSum(b, c)).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void update(long[] tree, int i, long diff) {
        while (i <= N + 1) {
            tree[i] += diff;
            i += (i & -i);
        }
    }

    static long prefixSum(long[] tree, int i) {
        long result = 0;
        while (i > 0) {
            result += tree[i];
            i -= (i & -i);
        }
        return result;
    }

    static void rangeUpdate(int b, int c, long d) {
        update(tree1, b, d);
        update(tree2, b, d * (b - 1));

        update(tree1, c + 1, -d);
        update(tree2, c + 1, -d * c);
    }

    static long sumUntil(int x) {
        return prefixSum(tree1, x) * x - prefixSum(tree2, x);
    }

    static long rangeSum(int b, int c) {
        return sumUntil(c) - sumUntil(b - 1);
    }
}