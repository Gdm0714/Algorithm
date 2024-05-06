import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] likes = new ArrayList[n * n];
        int[] order = new int[n * n];
        int[][] seat = new int[n][n];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int result = 0;

        StringTokenizer st;
        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            order[i] = idx;
            likes[idx] = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                likes[idx].add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int student : order) {
            int likeMax = Integer.MIN_VALUE, emptyMax = Integer.MIN_VALUE;
            int x = 0, y = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (seat[i][j] != 0) continue;
                    int likeCnt = 0, emptyCnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                            if (likes[student].contains(seat[nx][ny])) {
                                likeCnt++;
                            }
                            if (seat[nx][ny] == 0) emptyCnt++;
                        }
                    }
                    if (likeCnt > likeMax || (likeCnt == likeMax && emptyCnt > emptyMax)) {
                        likeMax = likeCnt;
                        emptyMax = emptyCnt;
                        x = i;
                        y = j;
                    }
                }
            }
            seat[x][y] = student + 1;
        }

        for (int student : order) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (seat[i][j] - 1 != student) continue;
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                            if (likes[student].contains(seat[nx][ny])) cnt++;
                        }
                    }
                    if (cnt == 1) result += 1;
                    else if (cnt == 2) result += 10;
                    else if (cnt == 3) result += 100;
                    else if (cnt == 4) result += 1000;
                }
            }
        }
        System.out.println(result);
    }
}