import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sol = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            sol[i] = Integer.parseInt(st.nextToken());
        }
        int[] pos = new int[2];
        int min = Integer.MAX_VALUE;
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = Math.abs(sol[l] + sol[r]);
            if (sum < min) {
                min = sum;
                pos[0] = l;
                pos[1] = r;

            }
            if (sol[l] + sol[r] > 0) {
                r--;
            } else {
                l++;
            }
        }
        System.out.println(sol[pos[0]] + " " + sol[pos[1]]);
    }
}