package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumInteger {
    public static int solution(int n) {
        int result = 0, num, sum;
        for (int i = 1; i < n; i++) {
            sum = 0;
            num = i;
            while (num < n & sum != n) {
                sum += num;
                num++;
                if (sum == n) result++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }
}
