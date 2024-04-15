import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int INF = 100000000;
    static ArrayList<Integer> list;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n;
        list = new ArrayList<>();
        while (true) {
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            list.add(n);
        }
        int min = Integer.MAX_VALUE;
        dp = new int[5][5][list.size() + 1];

        for (int i[][] : dp)
            for (int j[] : i) Arrays.fill(j, INF);

        dp[0][0][0] = INF;
        int res = solve(0, 0, 0);
        System.out.println(res);
    }

    static int solve(int left, int right, int index) {
        if (index >= list.size()) return 0;
        if (dp[left][right][index] != INF) return dp[left][right][index];
        int next = list.get(index);
        int toLeft = solve(next, right, index + 1) + move(left, next);
        int toRight = solve(left, next, index + 1) + move(right, next);
        return dp[left][right][index] = Math.min(toLeft, toRight);
    }

    static int move(int from, int to) {
        if (from == 0) return 2;
        if (from == to) return 1;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }
}