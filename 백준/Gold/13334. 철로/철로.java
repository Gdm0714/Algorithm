import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Person implements Comparable<Person> {
        int start;
        int end;

        Person(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Person o) {
            if (this.end != o.end) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            int start = Math.min(h, o);
            int end = Math.max(h, o);
            list.add(new Person(start, end));
        }

        int d = Integer.parseInt(br.readLine());

        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long max = 0;

        for (Person p : list) {
            if (p.end - p.start > d) continue;
            while (!pq.isEmpty() && pq.peek() < p.end - d) pq.poll();
            if (p.start >= p.end - d) pq.offer(p.start);
            max = Math.max(max, pq.size());
        }
        System.out.println(max);
    }
}
