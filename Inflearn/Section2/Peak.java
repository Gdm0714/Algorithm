package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Peak {
    public static int solution(int[][] num) {
        int result = 0;
        for (int i = 1; i < num.length - 1; i++) {
            for (int j = 1; j < num.length - 1; j++) {
                if (num[i][j] > num[i - 1][j] && num[i][j] > num[i + 1][j] && num[i][j] > num[i][j - 1] && num[i][j] > num[i][j + 1]) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[n + 2][n + 2];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(num));

    }
}
