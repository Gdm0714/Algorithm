import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static long[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n+1];
        for (int i = 1; i <= n; i++) arr[i] = Long.parseLong(br.readLine());
        

        tree = new long[n*4];
        init(1, n, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                arr[b] = c;
                update(1, n, 1, b, c);
            } else {
                sb.append(query(1, n, 1, b, c) % 1000000007).append('\n');
            }
        }

        System.out.println(sb);
    }

    static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = (init(start, mid, node*2) * init(mid+1, end, node*2+1)) % 1000000007;
    }

    static long update(int start, int end, int node, int index, long val) {
        if (index < start || index > end) return tree[node];
        if (start == end) return tree[node] = val;
        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, node*2, index, val) * update(mid+1, end, node*2+1, index, val)) % 1000000007;
    }

    static long query(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 1;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return (query(start, mid, node*2, left, right) * query(mid+1, end, node*2+1, left, right)) % 1000000007;
    }
}