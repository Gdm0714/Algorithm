package Silver.n1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] g;
    static boolean[] b;
    static Queue<Integer> queue = new LinkedList<>();

    static int n, m, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        g = new int[n + 1][n + 1];
        b = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            g[x][y] = g[y][x] = 1;
        }
        dfs(v);
        System.out.println();
        b = new boolean[n + 1];

        bfs(v);
    }

    static void dfs(int v) {
        b[v] = true;
        System.out.print(v + " ");
        for(int i = 0; i<=n; i++){
            if(g[v][i] == 1 && !b[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        queue.add(v);
        b[v] = true;

        while(!queue.isEmpty()){
            v = queue.poll();
            System.out.print(v + " ");

            for(int i = 0; i<=n; i++){
                if(g[v][i] == 1 && !b[i]){
                    queue.add(i);
                    b[i] = true;
                }
            }
        }
    }

}
