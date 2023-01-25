package onetwothreeplus;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = s.nextInt();

        int[] n = new int[11];

        n[1] = 1;
        n[2] = 2;
        n[3] = 4;

        for (int i = 4; i <= 10; i++) {
            n[i] = n[i - 1] + n[i - 2] + n[i - 3];
        }
        for(int i = 0; i<num; i++){
            int index = s.nextInt();
            bw.write(n[index] + "\n");
        }
        bw.flush();
    }
}
