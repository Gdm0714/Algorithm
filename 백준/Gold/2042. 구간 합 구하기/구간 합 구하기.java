import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        int depth = 0;
        while(Math.pow(2, depth) < n) {
            depth ++;
        }
        depth ++;
        int arraySize = (int)Math.pow(2, depth);
        int startIndex = (int)Math.pow(2, depth - 1);
        long[] tree = new long[arraySize];

        for(int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            long in = Long.parseLong(st.nextToken());
            tree[startIndex + i] = in;
        }

        for(int i = startIndex - 1 ; i >= 1 ; i --) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        for(int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            if(op == 1) {
                int targetIndex = (int) (startIndex + x - 1);
                long diff = y - tree[targetIndex];
                while(targetIndex > 0) {
                    tree[targetIndex] += diff;
                    targetIndex /= 2;
                }
            }
            else {
                int s = (int)x + startIndex - 1;
                int e = (int)y + startIndex - 1;
                long ans = 0;
                while(s <= e) {
                    if(s % 2 == 1) ans += tree[s];
                    if(e % 2 == 0) ans += tree[e];
                    s = (s + 1) / 2;
                    e = (e - 1) / 2;
                }
                System.out.println(ans);
            }
        }
    }
}