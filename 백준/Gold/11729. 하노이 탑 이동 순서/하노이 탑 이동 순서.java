import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        hanoi(n, "1", "2", "3");
        System.out.println(cnt);
        System.out.println(sb);
    }

    static void hanoi(int num, String start, String mid, String end) {
        if (num == 1) {
            cnt++;
            sb.append(start + " " + end + "\n");
        }
        else{
            hanoi(num-1, start, end, mid);
            cnt++;
            sb.append(start + " " + end + "\n");
            hanoi(num-1, mid, start, end);
        }
    }
}