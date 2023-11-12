package etc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;

        int minNum = Integer.MAX_VALUE;

        for (int i = m; i <= n; i++) {

            boolean b = true;

            if(i == 1){
                continue;
            }

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                sum += i;
                if (minNum > i) {
                    minNum = i;
                }
            }

        }
        if (sum == 0)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(minNum);
        }
    }
}
