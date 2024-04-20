import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] tails = new int[n];
        int size = 1;
        tails[0] = num[0];
        for (int i = 1; i < n; i++) {
            if (num[i] < tails[0]) {
                tails[0] = num[i];
            } else if (num[i] > tails[size - 1]) {
                tails[size++] = num[i];
            } else {
                tails[lowerBound(tails, size, num[i])] = num[i];
            }
        }

        System.out.println(size);
    }

    private static int lowerBound(int[] a, int length, int key) {
        int lo = 0;
        int hi = length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}