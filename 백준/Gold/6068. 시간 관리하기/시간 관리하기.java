import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr[i][0] = t;
            arr[i][1] = s;
        }

        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        int answer = arr[0][1];
        for(int i = 0; i < n; i++){
            answer = Math.min(answer, arr[i][1]) - arr[i][0];
            if(answer < 0){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(answer);
    }
}
