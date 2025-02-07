import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int start = 0;
        int cnt = 0;

        for (int end = 0; end < n; end++) {
            if (arr[end] % 2 == 1) cnt++;

            while (cnt > k) {
                if (arr[start] % 2 == 1) cnt--;
                start++;
            }
            max = Math.max(max, end - start + 1 - cnt);
        }
        System.out.println(max);
    }
}
