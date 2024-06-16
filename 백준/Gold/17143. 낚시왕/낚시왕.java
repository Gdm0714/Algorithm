import java.io.*;
import java.util.*;

public class Main {
    static int R, C, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Shark {
        int x, y, speed, dir, size;
        public Shark(int x, int y, int speed, int dir, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[R+1][C+1];
        Shark[] sharks = new Shark[M+1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            sharks[i] = new Shark(r, c, s, d, z);
            map[r][c] = i;
        }
        int result = 0;
        for (int i = 1; i <= C; i++) {
            for (int j = 1; j <= R; j++) {
                if (map[j][i] > 0) {
                    result += sharks[map[j][i]].size;
                    sharks[map[j][i]] = null;
                    break;
                }
            }
            map = new int[R+1][C+1];
            for (int j = 1; j <= M; j++) {
                if (sharks[j] != null) {
                    Shark shark = sharks[j];
                    int nx = shark.x;
                    int ny = shark.y;
                    int speed = shark.speed;
                    if (shark.dir < 2) speed %= (R-1)*2;
                    else speed %= (C-1)*2;
                    for (int k = 0; k < speed; k++) {
                        if (shark.dir == 0 && nx == 1) shark.dir = 1;
                        else if (shark.dir == 1 && nx == R) shark.dir = 0;
                        else if (shark.dir == 2 && ny == C) shark.dir = 3;
                        else if (shark.dir == 3 && ny == 1) shark.dir = 2;
                        nx += dx[shark.dir];
                        ny += dy[shark.dir];
                    }
                    shark.x = nx;
                    shark.y = ny;
                    if (map[nx][ny] == 0) map[nx][ny] = j;
                    else {
                        if (sharks[map[nx][ny]].size < shark.size) {
                            sharks[map[nx][ny]] = null;
                            map[nx][ny] = j;
                        } else sharks[j] = null;
                    }
                }
            }
        }
        System.out.println(result);
    }
}