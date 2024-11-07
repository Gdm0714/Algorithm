import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] score = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int[] result = new int[num + 1];
        result[1] = score[1];
        

        for (int i = 2; i <= num; i++) {
            if (i == 2) {
                result[2] = score[1] + score[2];
            } else if (i == 3) {
                result[3] = Math.max(score[1], score[2]) + score[3];
            } else
                result[i] = Math.max(result[i - 3] + score[i - 1], result[i - 2]) + score[i];
        }

        System.out.println(result[num]);

    }
}