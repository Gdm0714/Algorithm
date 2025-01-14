import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<int[]> list = new ArrayList<>();
        long total = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, a});
            total += a;
        }

        Collections.sort(list, Comparator.comparingInt(a -> a[0]));
        long sum = 0;

        for(int[] i: list){
            sum += i[1];
            if (sum >= (total + 1) / 2) {
                System.out.println(i[0]);
                break;
            }
        }
    }
}
