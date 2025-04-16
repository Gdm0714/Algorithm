import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        long[] count = countDigits(n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(count[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    public static long[] countDigits(long n) {
        long[] count = new long[10];

        if (n < 10) {
            count[0] = 0;
            for (int i = 1; i <= 9; i++) {
                count[i] = i <= n ? 1 : 0;
            }
            return count;
        }

        long base = 1;

        while (base <= n) {
            for (int j = 0; j < 10; j++) {

                long fullCycle = (n / (base * 10)) * base;

                long currentDigit = (n / base) % 10;
                if (currentDigit > j) {
                    fullCycle += base;
                } else if (currentDigit == j) {
                    fullCycle += (n % base) + 1;
                }

                if (j == 0) {
                    fullCycle -= base;
                }

                count[j] += fullCycle;
            }

            base *= 10;
        }

        return count;
    }
}