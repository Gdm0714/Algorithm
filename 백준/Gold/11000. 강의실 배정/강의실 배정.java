import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> classes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classes.add(new int[]{start, end});
        }

        classes.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] cls : classes) {
            if (!queue.isEmpty() && cls[0] >= queue.peek()) {
                queue.poll();
            }
            queue.add(cls[1]);
        }

        System.out.println(queue.size());
    }
}