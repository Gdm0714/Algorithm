

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Long[] result = new Long[t];
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            Long sum = 0L;

            while (pq.size() > 1) {
                long first = pq.poll();
                long second = pq.poll();

                long pay = first + second;
                sum += pay;

                pq.offer(pay);
            }
            result[i] = sum;
        }
        for (int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }
    }
}
