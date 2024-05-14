import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] b = new boolean[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int number = 10000;



        b[0] = b[1] = true;

        for (int i = 2; i * i <= number; i++) {
            if (!b[i]) {
                for (int j = i * i; j < number; j += i) b[j] = true;
            }
        }//에라토스테네스의 체 알고리즘(소수 판별)

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            int n = num / 2;

            for (int j = n; j >= 2; j--) {
                if (!b[j] && !b[num - j]) {
                    System.out.println(j + " " + (num - j));
                    break;
                }
            }
        }
    }
}