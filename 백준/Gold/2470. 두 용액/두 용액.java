import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0, end = n - 1;
        int min = Integer.MAX_VALUE;
        int minStart = start, minEnd = end;

        while (start < end) {
            int mid = (start + end) / 2;
            int sum = arr[start] + arr[end];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                minStart = start;
                minEnd = end;
            }
            if (sum < 0) start++;
            else end--;
        }

        System.out.println(arr[minStart] + " " + arr[minEnd]);
    }
}