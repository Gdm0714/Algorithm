import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] house = new int[N];
        for (int i = 0; i < N; i++) house[i] = Integer.parseInt(br.readLine());

        Arrays.sort(house);

        int left = 1, right = house[N - 1] - house[0];
        int maxDist = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            int prev = house[0];
            for (int i = 1; i < N; i++) {
                if (house[i] - prev >= mid) {
                    count++;
                    prev = house[i];
                }
            }
            if (count >= C) {
                maxDist = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(maxDist);
    }
}