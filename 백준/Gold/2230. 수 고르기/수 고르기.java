import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;

        while (end < n && start <= end) {
            int num = arr[end] - arr[start];

            if (num >= m) {
                min = Math.min(min, num);
                start++;
            } else {
                end++;
            }
        }
        System.out.println(min);
    }
}