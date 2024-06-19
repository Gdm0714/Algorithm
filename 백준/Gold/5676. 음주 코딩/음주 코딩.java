import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[n + 1];
            tree = new int[4 * n];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int value = Integer.parseInt(st.nextToken());
                arr[i] = Integer.compare(value, 0);
            }
            init(1, n, 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (cmd == 'C') {
                    update(1, n, 1, a, Integer.compare(b, 0));
                } else {
                    int result = query(1, n, 1, a, b);
                    sb.append(result > 0 ? '+' : (result < 0 ? '-' : '0'));
                }
            }
            System.out.println(sb);
        }
    }

    static int init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1);
    }

    static int update(int start, int end, int node, int index, int value) {
        if (index < start || end < index) return tree[node];
        if (start == end) return tree[node] = value;
        int mid = (start + end) / 2;
        return tree[node] = update(start, mid, node * 2, index, value) * update(mid + 1, end, node * 2 + 1, index, value);
    }

    static int query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return 1;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) * query(mid + 1, end, node * 2 + 1, left, right);
    }
}