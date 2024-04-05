
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] building = new int[n];
            int[] price = new int[n];
            int[] node = new int[n];
            ArrayList<Integer>[] arrayLists = new ArrayList[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                building[j] = Integer.parseInt(st.nextToken());
                arrayLists[j] = new ArrayList<>();
            }
            int start, end;
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                arrayLists[start - 1].add(end - 1);
                node[end - 1]++;

            }
            int w = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();

            for (int j = 0; j < n; j++) {
                if (node[j] == 0) {
                    price[j] = building[j];
                    queue.offer(j);

                }
            }
            for (int j = 0; j < n; j++) {
                int tmp = queue.poll();
                for (int idx : arrayLists[tmp]) {
                    price[idx] = Math.max(price[idx], building[idx] + price[tmp]);

                    if (--node[idx] == 0) queue.offer(idx);

                }
            }

            System.out.println(price[w - 1]);
        }
    }
}
