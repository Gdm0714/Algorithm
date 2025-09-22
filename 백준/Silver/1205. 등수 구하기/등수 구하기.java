import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        if (N == 0) {
            System.out.println(1);
            return;
        }
        
        st = new StringTokenizer(br.readLine());
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        
        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (scores[i] > newScore) {
                rank++;
            } else {
                break;
            }
        }
        
        if (rank <= P) {
            if (N == P && rank > N) {
                System.out.println(-1);
            } else if (N == P && scores[N-1] == newScore) {
                System.out.println(-1);
            } else {
                System.out.println(rank);
            }
        } else {
            System.out.println(-1);
        }
    }
}