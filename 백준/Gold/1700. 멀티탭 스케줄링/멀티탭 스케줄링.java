import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] schedule = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            schedule[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> plugged = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < k; i++) {
            int current = schedule[i];

            if (plugged.contains(current)) {
                continue;
            }

            if (plugged.size() < n) {
                plugged.add(current);
                continue;
            }

            int latestnext = -1;
            int remove = 0;

            for (int plug : plugged) {
                int nextUse = k;

                for (int j = i + 1; j < k; j++) {
                    if (schedule[j] == plug) {
                        nextUse = j;
                        break;
                    }
                }

                if (nextUse > latestnext) {
                    latestnext = nextUse;
                    remove = plug;
                }
            }

            plugged.remove(remove);
            plugged.add(current);
            answer++;
        }

        System.out.println(answer);
    }
}