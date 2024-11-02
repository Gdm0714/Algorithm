import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num;

        int[] n = new int[123456];

        int index = 0;

        while (true) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            int count = 0;
            for (int i = num + 1; i <= 2 * num; i++) {
                boolean b = true;

                if (i == 1)
                    continue;

                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    count++;

                }

            }
            n[index++] = count;

        }

        for (int i = 0; i < index; i++) {
            System.out.println(n[i]);
        }

    }
}