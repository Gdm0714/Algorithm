package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxSum {
    public static int solution(int[][] num) {
        int rowMax = 0, columnMax = 0, rowResult, columnResult, result = 0, rDia = 0, lDia = 0;
        for (int i = 0; i < num.length; i++) {
            rowResult = 0;
            columnResult = 0;
            for (int j = 0; j < num.length; j++) {
                rowResult += num[i][j];
                columnResult += num[j][i];
                if (rowMax < rowResult) rowMax = rowResult;
                if (columnMax < columnResult) columnMax = columnResult;
            }
            rDia += num[i][i];
            lDia += num[i][num.length - i - 1];
        }
        result = Math.max(Math.max(rowMax, columnMax), Math.max(rDia, lDia));
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(num));


    }
}
