package makeone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        int[] n = new int[num + 1];

        for (int i = 2; i <= num; i++) {
            n[i] = n[i - 1] + 1;

            if (i % 2 == 0)
                n[i] = Math.min(n[i], n[i / 2] + 1);

            if (i % 3 == 0)
                n[i] = Math.min(n[i], n[i / 3] + 1);
        }
        System.out.println(n[num]);
    }
}
