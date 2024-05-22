import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int distance = y - x;
            int max = (int) Math.sqrt(distance); // 이동 횟수의 제곱이 이동 거리보다 작거나 같은 가장 큰 이동 횟수

            if (max == Math.sqrt(distance)) {
                System.out.println(max * 2 - 1);
            } else if (distance <= max * max + max) {
                System.out.println(max * 2);
            } else {
                System.out.println(max * 2 + 1);
            }
        }
    }
}