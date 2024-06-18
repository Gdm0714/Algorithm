import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new long[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                if (a > b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                System.out.println(sum(b) - sum(a - 1));
            } else {
                long diff = b - sum(a, a);
                update(a, diff);
            }
        }
    }

    static long sum(int i) {
        long ans = 0;
        while (i > 0) {
            ans += tree[i];
            i -= i & -i;
        }
        return ans;
    }

    static long sum(int i, int j) {
        return sum(j) - sum(i - 1);
    }

    static void update(int i, long diff) {
        while (i <= n) {
            tree[i] += diff;
            i += i & -i;
        }
    }
}