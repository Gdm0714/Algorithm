import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] map = new long[n][2];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());
            sum += a;
            map[i][0] = x;
            map[i][1] = a;
        }

        Arrays.sort(map, Comparator.comparingLong(a -> a[0]));

        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += map[i][1];
            if(answer >= (sum + 1) / 2){
                System.out.println(map[i][0]);
                break;
            }
        }
    }
}
