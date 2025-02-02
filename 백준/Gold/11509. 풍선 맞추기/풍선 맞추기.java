

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[n];
        for (int i = 0; i < n; i++) num[i] = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000001];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[num[i]] > 0) {
                arr[num[i]]--;
                arr[num[i] - 1]++;
            } else {
                cnt++;
                arr[num[i] - 1]++;
            }
        }
        System.out.println(cnt);
    }
}
