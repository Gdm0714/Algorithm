import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        int b[] = new int[n];
        int c[] = new int[n];
        int d[] = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());

        }

        int ad[] = new int[n * n];
        int bc[] = new int[n * n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ad[idx] = a[i] + d[j];
                bc[idx] = b[i] + c[j];
                idx++;
            }
        }

        int l = 0, r = bc.length - 1;
        long cnt = 0;

        Arrays.sort(ad);
        Arrays.sort(bc);


        while (l < ad.length && r >= 0) {
            int sum = ad[l] + bc[r];
            if (sum == 0) {
                long adCnt = 1, bcCnt = 1;
                while (l + 1 < ad.length && ad[l] == ad[l + 1]) {
                    adCnt++;
                    l++;
                }
                while (r - 1 >= 0 && bc[r] == bc[r - 1]) {
                    bcCnt++;
                    r--;
                }
                cnt += adCnt * bcCnt;
                l++;
                r--;
            } else if (sum < 0) l++;
            else r--;
        }
        System.out.println(cnt);
    }
}
