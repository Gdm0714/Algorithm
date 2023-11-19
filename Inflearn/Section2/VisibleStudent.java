package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VisibleStudent {
    public static int solution(int[] height) {
        int cnt = 1;
        int index = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[index]) {
                cnt++;
                index = i;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(height));

    }
}
