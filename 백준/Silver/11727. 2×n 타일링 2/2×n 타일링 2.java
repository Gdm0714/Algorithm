import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[] result = new int[1001];

        result[0] = 0;
        result[1] = 1;
        result[2] = 3;

        for (int i = 3; i <= n; i++) {
            result[i] = (result[i - 1] + result[i - 2] * 2) % 10007;
        }
        System.out.println(result[n]);


    }
}