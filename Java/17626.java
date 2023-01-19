package foursquares;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();

        int[] n = new int[num + 1];
        n[1] = 1;

        for (int i = 2; i <= num; i++) {
            int minNum = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                if (minNum > n[i - j * j])
                    minNum = n[i - j * j];
            }
            n[i] = 1 + minNum;
        }
        System.out.println(n[num]);
    }
}
