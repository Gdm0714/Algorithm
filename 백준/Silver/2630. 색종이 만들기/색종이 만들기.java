import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][]sq;

    static int one = 0;

    static int zero = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        sq = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                sq[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rec(0, 0, n);
        
        System.out.println(zero);
        System.out.println(one);
        
    }
    static void rec(int row, int col, int n){
        int num = n / 2;

        if (colorCheck(row, col, n)) {
            if (sq[row][col] == 1)
                one++;
            else if (sq[row][col] == 0)
                zero++;
            return;
        }
        rec(row, col, num);
        rec(row, col + num, num);

        rec(row + num, col, num);
        rec(row + num, col + num, num);
    }

    static boolean colorCheck(int row, int col, int n) {
        int num = sq[row][col];

        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (num != sq[i][j])
                    return false;
            }
        }
        return true;
    }
}