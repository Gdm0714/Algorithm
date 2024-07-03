import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        long[] prefixSum = new long[N+1];
        long[] count = new long[M];
        count[0] = 1;
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = (prefixSum[i-1] + A[i]) % M;
            count[(int)prefixSum[i]]++;
        }
        long result = 0;
        for (int i = 0; i < M; i++) {
            if (count[i] >= 2) {
                result += count[i] * (count[i] - 1) / 2;
            }
        }
        System.out.println(result);
    }
}