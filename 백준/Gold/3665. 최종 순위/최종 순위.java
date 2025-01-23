import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] lastYear;
    static int[][] graph;
    static int[] inDegree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());

            lastYear = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                lastYear[i] = Integer.parseInt(st.nextToken());
            }

            graph = new int[n + 1][n + 1];
            inDegree = new int[n + 1];

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    graph[lastYear[i]][lastYear[j]] = 1;
                    inDegree[lastYear[j]]++;
                }
            }

            m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (graph[a][b] == 1) {
                    graph[a][b] = 0;
                    graph[b][a] = 1;
                    inDegree[b]--;
                    inDegree[a]++;
                } else {
                    graph[b][a] = 0;
                    graph[a][b] = 1;
                    inDegree[a]--;
                    inDegree[b]++;
                }
            }

            topologicalSort();
        }

        System.out.print(sb.toString());
    }

    static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        boolean isAmbiguous = false;
        boolean isImpossible = false;

        while (!q.isEmpty()) {
            if (q.size() > 1) {
                isAmbiguous = true;
            }

            int current = q.poll();
            result.add(current);

            for (int i = 1; i <= n; i++) {
                if (graph[current][i] == 1) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }

        if (result.size() != n) {
            isImpossible = true;
        }

        if (isImpossible) {
            sb.append("IMPOSSIBLE\n");
        } else if (isAmbiguous) {
            sb.append("?\n");
        } else {
            for (int x : result) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }
    }
}
