import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int start = 0;
        int end = n - 1;

        while(start <= end){
            int p = end - start - 1;
            int sum = p * Math.min(num[start], num[end]);

            max = Math.max(max, sum);

            if(num[start] < num[end]) start++;
            else end--;
        }
        System.out.println(max);
    }
}
