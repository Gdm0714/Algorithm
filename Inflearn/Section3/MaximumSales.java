package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSales {
    public static int solution(int[] a, int k) {
        int max, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        max = sum;
        for (int i = k; i < a.length; i++) {
            sum = sum - a[i - k] + a[i];
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print(solution(a, k));
    }
}
