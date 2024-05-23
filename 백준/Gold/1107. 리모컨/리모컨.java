import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new boolean[10];
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) arr[Integer.parseInt(st.nextToken())] = true;
        }

        int min = Math.abs(n - 100); // 숫자 버튼이 모두 고장난 경우

        for (int i = 0; i <= 1000000; i++) {
            int cnt = calculate(i);
            if (cnt > 0) {
                int toN = Math.abs(i - n);
                min = Math.min(min, cnt + toN);
            }
        }
        System.out.println(min);
    }

    static int calculate(int i) {
        if (i == 0) return arr[0] ? 0 : 1;

        int cnt = 0;
        while (i > 0) {
            if (arr[i % 10]) return 0;
            cnt += 1;
            i /= 10;
        }
        return cnt;
    }
}