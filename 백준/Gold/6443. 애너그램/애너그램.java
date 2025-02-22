import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char[] word;
    static boolean[] visited;
    static char[] current;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            word = input.toCharArray();
            Arrays.sort(word);
            visited = new boolean[word.length];
            current = new char[word.length];
            solution(0);
        }
        System.out.print(sb);
    }

    static void solution(int depth) {
        if (depth == word.length) {
            sb.append(new String(current)).append('\n');
            return;
        }

        char prev = '\0';
        for (int i = 0; i < word.length; i++) {
            if (!visited[i] && prev != word[i]) {
                visited[i] = true;
                current[depth] = word[i];
                solution(depth + 1);
                visited[i] = false;
                prev = word[i];
            }
        }
    }
}