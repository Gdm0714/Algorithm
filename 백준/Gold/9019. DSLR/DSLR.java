import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited = new boolean[10000];

    static class Register {
        int val;
        String cmd;

        Register(int val, String cmd) {
            this.val = val;
            this.cmd = cmd;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Arrays.fill(visited, false);
            System.out.println(bfs(A, B));
        }
    }

    static String bfs(int A, int B) {
        Queue<Register> queue = new LinkedList<>();
        queue.add(new Register(A, ""));
        visited[A] = true;
        while (!queue.isEmpty()) {
            Register point = queue.poll();
        
            if (point.val == B) {
                return point.cmd;
            }
        
            int d = (point.val * 2) % 10000;
            if (!visited[d]) {
                visited[d] = true;
                queue.add(new Register(d, point.cmd + "D"));
            }
        
            int s = (point.val == 0) ? 9999 : point.val - 1;
            if (!visited[s]) {
                visited[s] = true;
                queue.add(new Register(s, point.cmd + "S"));
            }
        
            int l = (point.val % 1000) * 10 + point.val / 1000;
            if (!visited[l]) {
                visited[l] = true;
                queue.add(new Register(l, point.cmd + "L"));
            }
        
            int r = (point.val % 10) * 1000 + point.val / 10;
            if (!visited[r]) {
                visited[r] = true;
                queue.add(new Register(r, point.cmd + "R"));
            }
        }
        return "";
    }
}