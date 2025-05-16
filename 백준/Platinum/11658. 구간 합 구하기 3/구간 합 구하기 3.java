import java.io.*;
import java.util.*;

public class Main {
    static int[][] tree;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int value = Integer.parseInt(st.nextToken());
                update(i, j, value);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());

            if (w == 0) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                int currentSum = sum(x, y, x, y);

                update(x, y, -currentSum);
                update(x, y, c);
            } else {
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());

                int result = sum(x1, y1, x2, y2);
                sb.append(result).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void update(int x, int y, int val) {
        for (int i = x; i <= n; i += (i & -i)) {
            for (int j = y; j <= n; j += (j & -j)) {
                tree[i][j] += val;
            }
        }
    }

    static int prefixSum(int x, int y) {
        int sum = 0;
        for (int i = x; i > 0; i -= (i & -i)) {
            for (int j = y; j > 0; j -= (j & -j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }

    static int sum(int x1, int y1, int x2, int y2) {
        return prefixSum(x2, y2) - prefixSum(x2, y1 - 1) - prefixSum(x1 - 1, y2) + prefixSum(x1 - 1, y1 - 1);
    }
}