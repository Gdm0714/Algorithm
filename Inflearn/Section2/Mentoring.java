package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mentoring {
    public static int solution(int[][] num, int n, int m) {
        int result = 0, count = 0, mentorRank, menteeRank;
        for (int mentor = 1; mentor <= n; mentor++) {
            for (int mentee = 1; mentee <= n; mentee++) {
                count = 0;
                for (int i = 0; i < m; i++) {
                    menteeRank = -1;
                    mentorRank = -1;
                    for (int j = 0; j < n; j++) {
                        if (num[i][j] == mentor) mentorRank = j;
                        if (num[i][j] == mentee) menteeRank = j;
                    }
                    if (mentorRank > menteeRank) count++;
                }
                if (count == m) result++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] num = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(num, n, m));
    }
}
