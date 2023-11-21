package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DetermineHead {
    public static int solution(int[][] num) {
        int result = 0, sum = 0;
        ArrayList<Integer> stu;
        for (int i = 0; i < num.length; i++) {
            stu = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < num.length; k++) {

                    if (k != i && num[i][j] == num[k][j] && !stu.contains(k)) stu.add(k);
                }
            }
            if (sum < stu.size()) {
                sum = stu.size();
                result = i;
            }
        }
        return result + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[n][5];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(num));
    }
}
