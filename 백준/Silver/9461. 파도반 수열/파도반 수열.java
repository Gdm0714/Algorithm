

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        long[] num = new long[101];

        num[0] = 0;
        num[1] = 1;
        num[2] = 1;
        num[3] = 1;
        num[4] = 2;
        num[5] = 2;
        for(int i = 6; i<=100; i++){
            num[i] = num[i-1]+num[i-5];
        }

        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(num[n]);
        }
    }
}
