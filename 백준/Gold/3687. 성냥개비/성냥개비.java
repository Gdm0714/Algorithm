import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        Long[] minDp = new Long[101];
        StringBuilder max;
        Arrays.fill(minDp, Long.MAX_VALUE);
        minDp[2] = 1L;
        minDp[3] = 7L;
        minDp[4] = 4L;
        minDp[5] = 2L;
        minDp[6] = 6L;
        minDp[7] = 8L;
        minDp[8] = 10L;
        int[] num = {1, 7, 4, 2, 0, 8}; // 각 개수로 만들 수 있는 최소값

        for (int i = 0; i < t; i++) {
            for (int k = 9; k <= 100; k++) {
                for (int j = 2; j <= 7; j++) {
                    String s = "" + minDp[k - j] + num[j - 2];
                    minDp[k] = Math.min(minDp[k], Long.parseLong(s));
                }
            }
            int n = Integer.parseInt(br.readLine());

            max = new StringBuilder();
            if (n % 2 == 1) max.append("7");
            else max.append("1");

            for (int j = 1; j < n / 2; j++) max.append("1");
            System.out.println(minDp[n] + " " + max.toString());
        }
    }
}