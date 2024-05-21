import java.io.*;
import java.util.*;

public class Main {
    static class Problem implements Comparable<Problem> {
        int num, level;

        Problem(int num, int level) {
            this.num = num;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.level == o.level) return this.num - o.num;
            return this.level - o.level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<Problem> problems = new TreeSet<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            problems.add(new Problem(num, level));
            map.put(num, level);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                problems.add(new Problem(num, level));
                map.put(num, level);
            } else if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) System.out.println(problems.last().num);
                else System.out.println(problems.first().num);
            } else if (command.equals("solved")) {
                int num = Integer.parseInt(st.nextToken());
                int level = map.get(num);
                problems.remove(new Problem(num, level));
            }
        }
    }
}