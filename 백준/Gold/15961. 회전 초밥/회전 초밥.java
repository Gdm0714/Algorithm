import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + k - 1];

        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for(int i = 0; i < k - 1; i++)
            arr[n + i] = arr[i];

        int[] eat = new int[d + 1];
        int cnt = 0;

        for(int i = 0; i < k; i++){
            if(eat[arr[i]]++ == 0) cnt++;
        }

        int max = cnt;
        if(eat[c] == 0) max++;

        for(int i = 1; i<= n - 1; i++){
            if(--eat[arr[i-1]] == 0) cnt--;

            if(eat[arr[i + k - 1]]++ == 0) cnt++;

            int cur = cnt;
            if(eat[c] == 0) cur++;
            max = Math.max(max, cur);
        }
        System.out.println(max);


    }
}
