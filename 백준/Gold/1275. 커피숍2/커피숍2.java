import java.io.*;
import java.util.*;

public class Main {
    static int n, q;
    static long[] tree;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        int size = 1;
        while (size < n) size *= 2;

        tree = new long[size * 2];
        arr = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        init(1, 1, n);

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (x > y) {
                bw.write(query(1, 1, n, y, x) + "\n");
            } else {
                bw.write(query(1, 1, n, x, y) + "\n");
            }

            update(1, 1, n, a, b - arr[a]);
            arr[a] = b;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static long init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = init(node * 2, start, mid) +
                init(node * 2 + 1, mid + 1, end);
    }

    static long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) +
                query(node * 2 + 1, mid + 1, end, left, right);
    }

    static void update(int node, int start, int end, int index, long diff) {
        if (index < start || end < index) {
            return;
        }

        tree[node] += diff;
        if (start != end) {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, index, diff);
            update(node * 2 + 1, mid + 1, end, index, diff);
        }
    }
}