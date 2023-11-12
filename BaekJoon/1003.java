package fibonacci;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();

        int[] zero = new int[41];
        int[] one = new int[41];

        zero[0] = 1;
        one[0] = 0;
        zero[1] = 0;
        one[1] = 1;

        int[] tc = new int[num];

        for (int i = 2; i <= 40; i++) {


            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];

        }
        for (int i = 0; i < num; i++) {
            tc[i] = s.nextInt();
        }
        for(int i = 0; i < num; i++){
            System.out.println(zero[tc[i]] + " " + one[tc[i]]);
        }

    }
}
