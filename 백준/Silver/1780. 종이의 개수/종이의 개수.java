import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;

    public static int minusOne = 0;
    public static int zero = 0;
    public static int plusOne = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {

                paper[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        rec(0, 0, n);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);
    }

    static void rec(int row, int col, int n) {

        int num = n / 3;
        
        if (colorCheck(row, col, n)) {
            if (paper[row][col] == -1)
                minusOne++;
            else if (paper[row][col] == 0)
                zero++;
            else
                plusOne++;
            return;
        }
        rec(row, col, num);
        rec(row, col + num, num);
        rec(row, col + 2 * num, num);

        rec(row + num, col, num);
        rec(row + num, col + num, num);
        rec(row + num, col + 2 * num, num);

        rec(row + 2 * num, col, num);
        rec(row + 2 * num, col + num, num);
        rec(row + 2 * num, col + 2 * num, num);

    }

    static boolean colorCheck(int row, int col, int n) {
        int num = paper[row][col];

        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (num != paper[i][j]) 
                    return false;
            }
        }
        return true;
    }

}