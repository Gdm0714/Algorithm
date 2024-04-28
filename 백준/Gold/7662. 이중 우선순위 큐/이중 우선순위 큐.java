import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeMap<Integer, Integer> treeMap;
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            treeMap = new TreeMap<>();


            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (s.equals("I"))
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                else if (s.equals("D")) {
                    if (!treeMap.isEmpty()) {
                        int key;
                        if (num == 1) key = treeMap.lastKey();
                        else key = treeMap.firstKey();
                        if (treeMap.put(key, treeMap.get(key) - 1) == 1) treeMap.remove(key);
                    }
                }
            }
            if (treeMap.isEmpty()) System.out.println("EMPTY");
            else System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
        }
    }
}
