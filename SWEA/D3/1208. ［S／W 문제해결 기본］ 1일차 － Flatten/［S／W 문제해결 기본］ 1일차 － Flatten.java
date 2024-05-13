
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[100];
        int[] result = new int[10];
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) arr[j] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);
            result[i] = arr[99] - arr[0];
        }

        for (int i = 0; i < 10; i++) System.out.println("#" + (i + 1) + " " + result[i]);
    }
}