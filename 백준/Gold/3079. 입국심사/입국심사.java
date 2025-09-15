import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] time = new long[n];
        long max = 0;

        for(int i = 0; i < n; i++){
            time[i] = Long.parseLong(br.readLine());
            max = Math.max(max, time[i]);
        }

        long start = 0;
        long end = max * m;
        long result = end;

        while(start <= end){
            long mid = (start + end) / 2;

            if(isFinished(time, m, mid)){
                result = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(result);
    }

    static boolean isFinished(long[]t, int m, long time){
        long sum = 0;
        for(long l: t){
            sum += time / l;

            if(sum >= m) return true;
        }
        return sum >= m;
    }
}