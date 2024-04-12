
import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static List<Integer>[] kid;
    static List<Pair> group;
    static boolean[] visited;
    static int[] candy;
    static int[] dp;

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        kid = new ArrayList[n+1];
        group = new ArrayList<>();
        visited = new boolean[n+1];
        candy = new int[n+1];
        dp = new int[k+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
            kid[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            kid[a].add(b);
            kid[b].add(a);
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                Pair sizeCandy = setGroup(i);
                group.add(sizeCandy);
            }
        }

        int ans = 0;
        dp[0] = 0;

        for(Pair sc : group) {
            for(int i = k - 1; i >= 0; i--) {
                if(i - sc.first >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - sc.first] + sc.second);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        System.out.println(ans);
    }

    static Pair setGroup(int x) {
        int s = 1;
        int c = candy[x];
        visited[x] = true;

        for(int i = 0; i < kid[x].size(); i++) {
            if(!visited[kid[x].get(i)]) {
                Pair sizeCandy = setGroup(kid[x].get(i));
                s += sizeCandy.first;
                c += sizeCandy.second;
            }
        }
        return new Pair(s, c);
    }
}