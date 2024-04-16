import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static int[] indegree;
    static ArrayList<Integer>[] order;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        indegree = new int[N + 1];
        order = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            order[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int size = Integer.parseInt(input[0]);
            int[] temp = new int[size];
            for (int j = 0; j < size; j++) {
                temp[j] = Integer.parseInt(input[j + 1]);
            }
            for (int j = 0; j < size - 1; j++) {
                if (!order[temp[j]].contains(temp[j + 1])) {
                    order[temp[j]].add(temp[j + 1]);
                    indegree[temp[j + 1]]++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int current = q.poll();
            result.add(current);

            for (int i = 0; i < order[current].size(); i++) {
                int next = order[current].get(i);
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        if (result.size() == N) {
            for (int i : result) {
                System.out.println(i);
            }
        } else {
            System.out.println(0);
        }
    }
}