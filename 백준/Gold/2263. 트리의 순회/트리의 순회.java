import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] inorder;
    static int[] postorder;
    static int[] position;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        inorder = new int[n];
        postorder = new int[n];
        position = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            position[inorder[i]] = i;
        }

        getPreorder(0, n - 1, 0, n - 1);
        System.out.println(sb.toString());
    }

    static void getPreorder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        int root = postorder[postEnd];
        sb.append(root).append(" ");

        int rootIndex = position[root];
        int leftSize = rootIndex - inStart;

        getPreorder(inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
        getPreorder(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}