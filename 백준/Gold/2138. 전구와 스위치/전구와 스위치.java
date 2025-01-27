import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static char[] cur;
    static char[] tar;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cur = br.readLine().toCharArray();
        tar = br.readLine().toCharArray();

        char[] case1 = cur.clone();
        int cnt1 = press(case1, 0);

        char[] case2 = cur.clone();
        case2[0] = case2[0] == '0' ? '1' :'0';
        case2[1] = case2[1] == '0' ? '1' :'0';
        int cnt2 = press(case2, 1);

        int result = Math.min(cnt1, cnt2);
        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    static int press(char[] lights, int cnt) {
        for (int i = 1; i < n; i++) {
            if (lights[i - 1] != tar[i - 1]) {
                lights[i - 1] = lights[i - 1] == '0' ? '1' :'0';
                lights[i] = lights[i] == '0' ? '1' :'0';
                if (i < n - 1) lights[i + 1] = lights[i + 1] == '0' ? '1' :'0';
                cnt++;
            }
        }
        return lights[n-1] == tar[n-1] ? cnt : Integer.MAX_VALUE;
    }
}
