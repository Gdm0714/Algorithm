import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point p) {
            if (this.x == p.x) {
                return this.y - p.y;
            } else {
                return this.x - p.x;
            }
        }
    }

    static long dis(Point p1, Point p2) {
        long dx = p1.x - p2.x;
        long dy = p1.y - p2.y;
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        Arrays.sort(points);
        System.out.println(closet(points, 0, n - 1));
    }

    static long closet(Point[] points, int start, int end) {
        if (end - start <= 2) {
            long min = Long.MAX_VALUE;
            for (int i = start; i <= end; i++) {
                for (int j = i + 1; j <= end; j++) {
                    min = Math.min(min, dis(points[i], points[j]));
                }
            }
            return min;
        }

        int mid = (start + end) / 2;
        long min = Math.min(closet(points, start, mid), closet(points, mid + 1, end));
        List<Point> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            int distance = points[i].x - points[mid].x;
            if (distance * distance < min) {
                list.add(points[i]);
            }
        }
        Collections.sort(list, Comparator.comparingInt(p -> p.y));
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size() && (list.get(j).y - list.get(i).y) * (list.get(j).y - list.get(i).y) < min; j++) {
                min = Math.min(min, dis(list.get(i), list.get(j)));
            }
        }
        return min;
    }
}