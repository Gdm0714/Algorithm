
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int MAX = 1000000;
    static int[] mobius = new int[MAX+1];
    static long k;

    static long calculate(long n) {
        long count = 0;
        for (int i = 1; i*i <= n; i++) {
            count += mobius[i] * (n / (i*i));
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Long.parseLong(br.readLine());

        Arrays.fill(mobius, 1);
        for (int i = 2; i <= MAX; i++) {
            if (mobius[i] == 1) {
                for (int j = i; j <= MAX; j += i) {
                    mobius[j] *= -i;
                }
                if ((long)i * i <= MAX) {
                    for (int j = i * i; j <= MAX; j += i * i) {
                        mobius[j] = 0;
                    }
                }
            }
        }
        for (int i = 2; i <= MAX; i++) {
            if (mobius[i] == i) {
                mobius[i] = 1;
            } else if (mobius[i] == -i) {
                mobius[i] = -1;
            } else if (mobius[i] < 0) {
                mobius[i] = 1;
            } else if (mobius[i] > 0) {
                mobius[i] = -1;
            }
        }

        long left = 1;
        long right = 2 * k;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (calculate(mid) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}
