
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String s = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(s.substring(1, s.length() - 1), ",");
            for (int j = 1; j <= 2 * n; j += 2) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            System.out.println(ac(p, deque));
        }
    }

    static String ac(String p, Deque<Integer> deque) {
        boolean b = false;
        for (char cmd : p.toCharArray()) {
            if (cmd == 'R') b = !b;
            else {
                if (deque.isEmpty()) return "error";
                if (b) deque.removeLast();
                else deque.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder("[");
        while (!deque.isEmpty()) {
            sb.append(b ? deque.removeLast() : deque.removeFirst());
            if (!deque.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}