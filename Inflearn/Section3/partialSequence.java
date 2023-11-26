package section3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class partialSequence {
    public static int solution(int[] a, int m) {
        int result = 0, sum = 0, n = a.length;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == m) {
                result++;
            }
            int complement = sum - m;
            if (sumMap.containsKey(complement)) {
                result += sumMap.get(complement);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(num, m));
    }
}

