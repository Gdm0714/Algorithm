import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) return this.start - o.start;
            else return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings);
        int cnt = 0;
        int tmp = 0;
        for (Meeting m : meetings) {
            if (tmp <= m.start) {
                tmp = m.end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}