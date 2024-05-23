import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<int[]> chicken, house;
    static int[] selected;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) house.add(new int[]{i, j});
                else if (value == 2) chicken.add(new int[]{i, j});
            }
        }
        selected = new int[m];
        combination(chicken.size(), m, 0, 0);
        System.out.println(min);
    }

    static void combination(int n, int r, int index, int depth) {
        if (r == 0) {
            calculate();
            return;
        }
        if (depth == n) return;
        selected[index] = depth;
        combination(n, r - 1, index + 1, depth + 1);
        combination(n, r, index, depth + 1);
    }

    static void calculate() {
        int sum = 0;
        for (int i = 0; i < house.size(); i++) {
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int[] selectedChicken = chicken.get(selected[j]);
                int dist = Math.abs(house.get(i)[0] - selectedChicken[0]) + Math.abs(house.get(i)[1] - selectedChicken[1]);
                minDist = Math.min(minDist, dist);
            }
            sum += minDist;
        }
        min = Math.min(min, sum);
    }
}