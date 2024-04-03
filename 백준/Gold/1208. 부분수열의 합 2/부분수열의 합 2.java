import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] arr;

    static List<Integer> l, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        long cnt = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        l = new ArrayList<>();
        r = new ArrayList<>();

        dfs(0, 0, n / 2, l);
        dfs(0, n / 2, n, r);

        Collections.sort(l);
        Collections.sort(r);
        int lPoint = 0;
        int rPoint = r.size() - 1;

        while (true) {
            if (lPoint == l.size() || rPoint < 0) break;
            int left = l.get(lPoint);
            int right = r.get(rPoint);

            if (left + right == s) {
                long lCnt = 0;
                while (lPoint < l.size() && l.get(lPoint) == left) {
                    lCnt++;
                    lPoint++;
                }

                long rCnt = 0;
                while (rPoint >= 0 && r.get(rPoint) == right) {
                    rCnt++;
                    rPoint--;
                }
                cnt += rCnt * lCnt;
            }
            if (left + right > s) rPoint--;
            if (left + right < s) lPoint++;
        }


        if (s == 0) System.out.println(cnt - 1);
        else System.out.println(cnt);

    }

    static void dfs(int sum, int start, int end, List<Integer> list) {
        if (start == end) {
            list.add(sum);
            return;
        }
        dfs(sum, start + 1, end, list);
        dfs(sum + arr[start], start + 1, end, list);
    }
}