import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] isSquare = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long start = ((min + square - 1) / square) * square;

            for (long j = start; j <= max; j += square) {
                isSquare[(int) (j - min)] = true;
            }
        }

        int count = 0;
        for (boolean b : isSquare) {
            if (!b) {
                count++;
            }
        }

        System.out.println(count);
    }
}