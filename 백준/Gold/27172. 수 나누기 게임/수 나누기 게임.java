import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) max = Math.max(max, x[i] = Integer.parseInt(st.nextToken()));

        int[] P = new int[n + 1];
        int[] pos = new int[max + 1];
        
        for (int i = 0; i < n; i++) pos[x[i]] = i + 1;

        for (int mod : x)
            for (int i = mod * 2; i <= max; i += mod) {
                if (pos[i] != 0) {
                    P[pos[i]]--;
                    P[pos[mod]]++;
                }
            }
        for (int i = 1; i <= n; i++) sb.append(P[i]).append(" ");
        System.out.print(sb);
    }
}