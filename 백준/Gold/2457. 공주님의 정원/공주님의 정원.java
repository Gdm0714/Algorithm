import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> flower = new ArrayList<>();
        int[] days = { 0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            int start = days[startMonth] + startDay;
            int end = days[endMonth] + endDay;

            flower.add(new int[] { start, end });
        }

        Collections.sort(flower, (a, b) -> a[0] - b[0]);

        int start = days[3] + 1;
        int end = days[11] + 30;

        int cnt = 0;
        int idx = 0;

        while (start <= end) {
            int max = 0;
            boolean found = false;

            while (idx < n && flower.get(idx)[0] <= start) {
                if (flower.get(idx)[1] > start) {
                    found = true;
                    max = Math.max(max, flower.get(idx)[1]);
                }
                idx++;
            }
            if (!found) {
                System.out.println(0);
                return;
            }
            cnt++;
            start = max;
        }
        System.out.println(cnt);
    }
}
