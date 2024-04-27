import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<String> set = new HashSet<>();
    static int[] pair;
    static Stack<Integer> stack = new Stack<>();
    static boolean[] visited;
    static String s;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        pair = new int[s.length()];
        visited = new boolean[s.length()];
        index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int n = stack.pop();
                pair[i] = n;
                pair[n] = i;
            }
        }

        dfs();
        set.remove(s);
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        for (String result : list) {
            System.out.println(result);
        }
    }

    static void dfs() {
        if (index >= s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (!visited[i]) {
                    sb.append(s.charAt(i));
                }
            }
            set.add(sb.toString());
            return;
        }
        if (s.charAt(index) == '(') {
            visited[index] = true;
            visited[pair[index]] = true;
            index++;
            dfs();
            index--;
            visited[index] = false;
            visited[pair[index]] = false;
        }
        index++;
        dfs();
        index--;
    }
}