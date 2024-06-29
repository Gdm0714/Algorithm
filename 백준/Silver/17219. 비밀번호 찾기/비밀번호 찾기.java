import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> pw = new HashMap<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pw.put(st.nextToken(), st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            bw.write(pw.get(br.readLine()) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}