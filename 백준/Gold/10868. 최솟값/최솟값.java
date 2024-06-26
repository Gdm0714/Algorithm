import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        tree = new int[N*4];
        init(1, N, 1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(query(1, N, 1, a, b)).append('\n');
        }

        System.out.println(sb);
    }

    static int init(int start, int end, int node) {
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(start, mid, node*2), init(mid+1, end, node*2+1));
    }

    static int query(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return Integer.MAX_VALUE;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return Math.min(query(start, mid, node*2, left, right), query(mid+1, end, node*2+1, left, right));
    }
}