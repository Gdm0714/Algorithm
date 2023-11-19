package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Minority {
    public static int solution(int n) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            boolean b = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    b = false;
                    break;
                }
            }
            if (b == true){
                result++;
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
