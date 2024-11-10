import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int m = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            System.out.println((m / 2) + 1);

            int count = 0;
            int nums = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (nums < m) {
                count++;
                nums++;
                if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
                if (nums % 2 == 0) {
                    maxHeap.add(Integer.parseInt(st.nextToken()));
                } else {
                    minHeap.add(Integer.parseInt(st.nextToken()));
                }

                if (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                    int tmp = minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(tmp);
                }
                if (nums % 2 == 1) {
                    System.out.print(minHeap.peek() + " ");
                    count++;
                }
                if(count == 10) {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}
