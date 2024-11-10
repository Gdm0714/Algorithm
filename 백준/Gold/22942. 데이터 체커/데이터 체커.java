import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> points = new ArrayList<>();
        HashSet<Integer> positions = new HashSet<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (!positions.add(x - r) || !positions.add(x + r)) {
                System.out.println("NO");
                return;
            }

            points.add(new Point(x - r, i, true));
            points.add(new Point(x + r, i, false));
        }

        points.sort((a, b) -> {
            if (a.pos != b.pos) {
                return a.pos - b.pos;
            }
            return Boolean.compare(b.isStart, a.isStart);
        });

        Stack<Integer> stack = new Stack<>();

        for (Point point : points) {
            if (point.isStart) {
                stack.push(point.idx);
            } else {
                if (stack.isEmpty() || stack.pop() != point.idx) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }

    static class Point {
        int pos, idx;
        boolean isStart;

        Point(int pos, int idx, boolean isStart) {
            this.pos = pos;
            this.idx = idx;
            this.isStart = isStart;
        }
    }
}