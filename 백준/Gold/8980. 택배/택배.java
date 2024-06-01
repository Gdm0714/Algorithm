import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Box implements Comparable<Box> {
        int start, end, num;

        Box(int start, int end, int num) {
            this.start = start;
            this.end = end;
            this.num = num;
        }

        @Override
        public int compareTo(Box o) {
            if (this.end == o.end) return o.start - this.start;
            else return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        Box[] boxes = new Box[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            boxes[i] = new Box(start, end, num);
        }

        Arrays.sort(boxes);

        int[] truck = new int[n + 1];
        Arrays.fill(truck, c);
        int total = 0;

        for (Box box : boxes) {
            int min = c;
            for (int i = box.start; i < box.end; i++) {
                min = Math.min(min, truck[i]);
            }

            min = Math.min(min, box.num);
            for (int i = box.start; i < box.end; i++) {
                truck[i] -= min;
            }

            total += min;
        }

        System.out.println(total);
    }
}