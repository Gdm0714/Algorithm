import java.io.*;
import java.util.*;

public class Main {
    static int n, w;
    static int[][] events;
    static int[][] dp;
    static int[][] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        w = Integer.parseInt(br.readLine());

        events = new int[w + 1][2];
        dp = new int[w + 1][w + 1];
        path = new int[w + 1][w + 1];

        for (int i = 1; i <= w; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            events[i][0] = Integer.parseInt(st.nextToken());
            events[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= w; i++) {
            Arrays.fill(dp[i], -1);
        }

        int minDistance = solve(0, 0);
        bw.write(minDistance + "\n");

        printPath(0, 0, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int police1, int police2) {
        if (Math.max(police1, police2) == w) {
            return 0;
        }

        if (dp[police1][police2] != -1) {
            return dp[police1][police2];
        }

        int next = Math.max(police1, police2) + 1;

        int dist1 = getDistance(police1, next, true) + solve(next, police2);

        int dist2 = getDistance(police2, next, false) + solve(police1, next);

        if (dist1 < dist2) {
            path[police1][police2] = 1;
            dp[police1][police2] = dist1;
        } else {
            path[police1][police2] = 2;
            dp[police1][police2] = dist2;
        }

        return dp[police1][police2];
    }
    static int getDistance(int from, int to, boolean isFirstCar) {
        int x1, y1;

        if (from == 0) {
            if (isFirstCar) {
                x1 = 1;
                y1 = 1;
            } else {
                x1 = n;
                y1 = n;
            }
        } else {
            x1 = events[from][0];
            y1 = events[from][1];
        }

        int x2 = events[to][0];
        int y2 = events[to][1];

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static void printPath(int police1, int police2, BufferedWriter bw) throws IOException {
        if (Math.max(police1, police2) == w) {
            return;
        }

        bw.write(path[police1][police2] + "\n");

        if (path[police1][police2] == 1) {
            printPath(Math.max(police1, police2) + 1, police2, bw);
        } else {
            printPath(police1, Math.max(police1, police2) + 1, bw);
        }
    }
}