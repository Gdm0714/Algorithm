import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        StringTokenizer st2;
        int result = 0;

        int cnt = 0;
        while (st.hasMoreTokens()) {
            int sum = 0;
            st2 = new StringTokenizer(st.nextToken(), "+");
            while ((st2.hasMoreTokens())) {
                sum += Integer.parseInt(st2.nextToken());
            }

            if(cnt>0){
                result -= sum;
            }
            else{
                result = sum;
            }
            cnt++;
        }
        System.out.println(result);
    }
}