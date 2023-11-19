package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RockScissorsPaper {
    public static void solution(int[]a, int[]b){
        char[] result = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            if(a[i] == 1){
                if(b[i] == 1)
                    result[i] = 'D';
                else if(b[i] == 2)
                    result[i] = 'B';
                else
                    result[i] = 'A';
            }
            else if(a[i] == 2){
                if(b[i] == 1)
                    result[i] = 'A';
                else if(b[i] == 2)
                    result[i] = 'D';
                else
                    result[i] = 'B';
            }
            else{
                if(b[i] == 1)
                    result[i] = 'B';
                else if(b[i] == 2)
                    result[i] = 'A';
                else
                    result[i] = 'D';
            }
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        solution(a, b);

    }
}
