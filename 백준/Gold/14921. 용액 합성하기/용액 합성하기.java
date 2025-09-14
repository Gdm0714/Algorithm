import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        

        int left = 0;
        int right = n - 1;
        int closestToZero = a[left] + a[right];

        while (left < right) {
            int sum = a[left] + a[right];

            if (Math.abs(sum) < Math.abs(closestToZero)) {
                closestToZero = sum;
            }

            if (sum > 0) {
                right--;
            }
            else if (sum < 0) {
                left++;
            }
            else {
                break;
            }
        }

        System.out.println(closestToZero);
    }
}