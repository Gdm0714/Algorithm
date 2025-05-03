import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        long value;
        Node left, right;

        Node() {}

        Node(long value) {
            this.value = value;
        }

        Node(long value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static Node build(int[] arr, int start, int end) {
        if (start == end) {
            return new Node(arr[start]);
        }

        int mid = (start + end) / 2;
        Node left = build(arr, start, mid);
        Node right = build(arr, mid + 1, end);

        return new Node(left.value + right.value, left, right);
    }

    static Node update(Node node, int start, int end, int idx, int val) {
        if (idx < start || idx > end) {
            return node;
        }

        if (start == end) {
            return new Node(val);
        }

        int mid = (start + end) / 2;
        Node newLeft = update(node.left, start, mid, idx, val);
        Node newRight = update(node.right, mid + 1, end, idx, val);

        return new Node(newLeft.value + newRight.value, newLeft, newRight);
    }

    static long query(Node node, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return 0;
        }

        if (left <= start && end <= right) {
            return node.value;
        }

        int mid = (start + end) / 2;
        long leftSum = query(node.left, start, mid, left, right);
        long rightSum = query(node.right, mid + 1, end, left, right);

        return leftSum + rightSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        List<Node> versions = new ArrayList<>();
        versions.add(build(arr, 1, N));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());

                Node newRoot = update(versions.get(versions.size() - 1), 1, N, idx, val);
                versions.add(newRoot);
            } else {
                int k = Integer.parseInt(st.nextToken());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                long result = query(versions.get(k), 1, N, left, right);
                sb.append(result).append("\n");
            }
        }

        System.out.print(sb);
    }
}