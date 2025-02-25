import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int result = 0;
        int tmp = 0;

        for(int i = 0; i < n; i++){
            int start = arr[i][0];
            int end = arr[i][1];

            if(start > tmp) {
                tmp = start;
            }

            while(tmp < end){
                result ++;
                tmp += l;
            }
        }

//        boolean[] visited = new boolean[arr[n - 1][1] + 1];
//
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            int length = 0;
//            for (int j = arr[i][0] + 1; j <= arr[i][1]; j++) {
//                if (!visited[j]) length++;
//            }
//            int cnt = (int) Math.ceil((double) length / l);
//            int idx = arr[i][0] + 1;
//            for (int j = 0; j < l * cnt; j++) {
//                visited[idx] = true;
//                idx++;
//            }
//            result += cnt;
//        }


        System.out.println(result);
    }
}