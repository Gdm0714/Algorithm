import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] w = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) w[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(w);

        int target = 1;

        for (int i = 0; i < n; i++) {
            if (target < w[i]) break;
            target += w[i];
        }
        System.out.println(target);
    }
}