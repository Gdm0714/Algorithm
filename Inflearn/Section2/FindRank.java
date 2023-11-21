package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindRank {
    public static void solution(int[] num) {
        int[] result = new int[num.length];
        int rank;
        for (int i = 0; i < num.length; i++) {
            rank = 1;
            for (int j = 0; j < num.length; j++) {
                if(num[i] < num[j]){
                    rank++;
                }
            }
            result[i] = rank;
            System.out.print(result[i] + " ");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        solution(num);
    }

}
