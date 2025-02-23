import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());

        long start = 1;
        long end = 1;
        boolean found = false;

        while (end <= 100000) {
            long weightDiff = end * end - start * start;

            if (weightDiff == g && start < end) {
                System.out.println(end);
                found = true;
                end++;
            }
            else if (weightDiff > g) {
                start++;
            }
            else {
                end++;
            }

            if (start == end) end++;
        }

        if (!found) System.out.println(-1);

    }
}