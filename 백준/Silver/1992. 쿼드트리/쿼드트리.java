import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(quadTree(0, 0, n));
    }

    static String quadTree(int x, int y, int n) {
        if (isSame(x, y, n)) return String.valueOf(arr[x][y]);
        int i = n / 2;
        return "(" + quadTree(x, y, i) + quadTree(x, y + i, i) + quadTree(x + i, y, i) + quadTree(x + i, y + i, i) + ")";
    }

    static boolean isSame(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != arr[x][y]) return false;
            }
        }
        return true;
    }
}