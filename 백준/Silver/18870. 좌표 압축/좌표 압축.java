import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int []num = new int[n];
        int []num2 = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();



        for(int i = 0; i<n; i++){
            num[i] = num2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num2);

        int rank = 0;

        for(int v : num2) {

            if(!map.containsKey(v)) {
                map.put(v, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int key : num) {
            int ranking = map.get(key);
            sb.append(ranking).append(' ');
        }

        System.out.println(sb);
    }
}