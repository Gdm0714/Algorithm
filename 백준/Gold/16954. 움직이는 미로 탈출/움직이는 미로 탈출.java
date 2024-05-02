
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] chess;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, -1, 1, 0, 1, -1, 1, -1};
    static Queue<int[]> queue = new LinkedList<>();
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chess = new char[8][8];
        for (int i = 0; i < 8; i++) {
            chess[i] = br.readLine().toCharArray();
        }
        result = 0;
        bfs();
        System.out.println(result);
    }

    static void bfs() {
        queue.add(new int[]{7, 0});

        while (!queue.isEmpty()) {
            int size = queue.size();
            visited = new boolean[8][8];
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                if (point[0] == 0 && point[1] == 7) {
                    result = 1;
                    return;
                }
                if (chess[point[0]][point[1]] == '.') {
                    for (int j = 0; j < 9; j++) {
                        int nx = point[0] + dx[j];
                        int ny = point[1] + dy[j];
                        if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && !visited[nx][ny] && chess[nx][ny] == '.') {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            for (int i = 6; i >= 0; --i) {
                for (int j = 0; j < 8; ++j) {
                    chess[i + 1][j] = chess[i][j];
                }
            }
            for (int i = 0; i < 8; i++) {
                chess[0][i] = '.';
            }
        }
        result = 0;
    }
}
