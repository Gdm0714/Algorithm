import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static class Node {
        TreeMap<String, Node> map = new TreeMap<>();

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node node = new Node();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            Node cur = node;
            for (int j = 0; j < k; j++) {
                String s = st.nextToken();
                cur.map.putIfAbsent(s, new Node());
                cur = cur.map.get(s);
            }
        }
        print(node, 0);
    }

    static void print(Node node, int cnt) {
        for (Map.Entry<String, Node> entry : node.map.entrySet()) {
            for(int i = 0; i < cnt; i++){
                System.out.print("--");
            }
            System.out.println(entry.getKey());
            print(entry.getValue(), cnt + 1);
        }
    }
}
