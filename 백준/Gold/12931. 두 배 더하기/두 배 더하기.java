import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int operations = 0;

        while (hasPositive(b)) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (b[i] % 2 == 1) {
                    cnt++;
                    b[i]--;
                }
            }
            operations += cnt;

            if (hasPositive(b)) {
                for (int i = 0; i < n; i++) {
                    b[i] /= 2;
                }
                operations++;
            }
        }

        System.out.println(operations);
    }

    private static boolean hasPositive(int[] arr) {
        for (int x : arr) {
            if (x > 0)
                return true;
        }
        return false;
    }
}
