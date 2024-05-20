import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, r, c;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cnt = 0;
        zSearch(Math.pow(2, n), 0, 0);
    }


    static void zSearch(double n, int x, int y) {
        if (x == r && y == c) {
            System.out.println(cnt);
            return;
        }

        if (x <= r && r < x + n && y <= c && c < y + n) {
            int i = (int) n / 2;
            zSearch(i, x, y);
            zSearch(i, x, y + i);
            zSearch(i, x + i, y);
            zSearch(i, x + i, y + i);
        } else cnt += n * n;
    }
}