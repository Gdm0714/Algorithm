import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Long result = 0L;
        String answer = "success";
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());
            if (name.equals("in")) result += price;
            else if (name.equals("out")) result -= price;
            if(result < 0) {
                answer = "fail";
            }
        }
        System.out.println(answer);
    }
}