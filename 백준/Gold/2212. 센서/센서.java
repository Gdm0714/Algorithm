import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] sensor = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) sensor[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sensor);

        Integer[] tmp = new Integer[n - 1];
        for (int i = 0; i < n - 1; i++) tmp[i] = sensor[i + 1] - sensor[i];

        Arrays.sort(tmp, (o1, o2) -> o2 - o1);

        int result = 0;
        for (int i = k - 1; i < n - 1; i++) result += tmp[i];


        System.out.println(result);
    }
}