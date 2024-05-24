
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) crane[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(crane, Collections.reverseOrder());

        int m = Integer.parseInt(br.readLine());
        Integer[] box = new Integer[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) box[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(box, Collections.reverseOrder());

        if (crane[0] < box[0]) {
            System.out.println(-1);
            return;
        }

        int[] positions = new int[n];
        int cnt = 0;
        int time = 0;

        while (cnt < m) {
            for (int i = 0; i < n; i++) {
                while (positions[i] < m) {
                    if (box[positions[i]] != null && crane[i] >= box[positions[i]]) {
                        cnt++;
                        box[positions[i]] = null;
                        positions[i]++;
                        break;
                    }
                    positions[i]++;
                }
            }
            time++;
        }

        System.out.println(time);
    }
}
