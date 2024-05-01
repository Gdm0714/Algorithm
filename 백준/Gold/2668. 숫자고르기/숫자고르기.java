import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static boolean[] visited;
    static int[] num;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs(i, i);
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void dfs(int start, int idx) {
        if (visited[idx]) {
            if (start == idx) list.add(start);
        } else {
            visited[idx] = true;
            dfs(start, num[idx]);
        }
    }
}