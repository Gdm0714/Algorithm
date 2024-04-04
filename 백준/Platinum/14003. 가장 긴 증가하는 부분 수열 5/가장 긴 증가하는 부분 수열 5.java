import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] D = new int[1000000];
        D[0] = a[0];
        int[] result = new int[a.length];
        result[0] = 0;
        int size = 1;
        for (int i = 1; i < N; i++) {
            int index = Arrays.binarySearch(D, 0, size, a[i]);

            index = index >= 0 ? index : Math.abs(index) - 1;
            D[index] = a[i];
            if (index == size) {
                size++;
            }
            result[i] = index;
        }
        String[] str = new String[size];
        System.out.println(size);
        size--;
        for(int j = a.length-1; j >= 0; j--) {
            if (size == -1) break;
            if (result[j] == size) {
                str[size] = String.valueOf(a[j]);
                size--;
            }
        }
        System.out.println(String.join(" ", str));
    }
}