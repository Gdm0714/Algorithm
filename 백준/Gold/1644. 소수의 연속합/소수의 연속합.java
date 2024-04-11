
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[n + 1];
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                num.add(i);
                for (int j = i + i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
        int cnt = 0;
        int left = 0, right = 0, sum = 0;

        while (true) {
            if (sum >= n) {
                sum -= num.get(left++);
            } else if (right == num.size()) {
                break;
            } else {
                sum += num.get(right++);
            }
            if (sum == n) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}