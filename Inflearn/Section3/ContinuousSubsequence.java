package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSubsequence {
    public static int solution(int k, int num[]) {
        int result = 0, cnt = 0, tmp = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 0) cnt++;
            while (cnt > k) {
                if (num[tmp] == 0) cnt--;
                tmp++;
            }
            result = Math.max(result, i - tmp + 1);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int num[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(k, num));
    }
}
