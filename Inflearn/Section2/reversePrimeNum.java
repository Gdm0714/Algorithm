package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class reversePrimeNum {
    public static void solution(int[] num) {
        ArrayList<Character> al = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int reverseNum;
        for (int i = 0; i < num.length; i++) {
            boolean b = true;
            reverseNum = 0;
            while (num[i] != 0) {
                reverseNum = reverseNum * 10 + num[i] % 10;
                num[i] /= 10;
            }
            if (reverseNum == 1){
                b = false;
            }
            for (int j = 2; j <= Math.sqrt(reverseNum); j++) {
                if (reverseNum % j == 0) {
                    b = false;
                    break;
                }
            }
            if (b == true) {
                System.out.print(reverseNum + " ");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        solution(num);
    }
}
