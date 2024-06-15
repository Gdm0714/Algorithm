import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Shark babyShark;
    static class Shark {
        int x, y, size, eat;
        public Shark(int x, int y, int size, int eat) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eat = eat;
        }
    }
    static class Fish {
        int x, y, dist;
        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    babyShark = new Shark(i, j, 2, 0);
                    map[i][j] = 0;
                }
            }
        }
        int result = 0;
        while (true) {
            Fish fish = bfs();
            if (fish == null) break;
            babyShark.x = fish.x;
            babyShark.y = fish.y;
            babyShark.eat++;
            if (babyShark.eat == babyShark.size) {
                babyShark.size++;
                babyShark.eat = 0;
            }
            map[fish.x][fish.y] = 0;
            result += fish.dist;
        }
        System.out.println(result);
    }
    static Fish bfs() {
        Queue<Fish> queue = new LinkedList<>();
        ArrayList<Fish> fishes = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        queue.offer(new Fish(babyShark.x, babyShark.y, 0));
        visited[babyShark.x][babyShark.y] = true;
        int dist = -1;
        while (!queue.isEmpty()) {
            Fish fish = queue.poll();
            if (dist != -1 && fish.dist > dist) break;
            if (map[fish.x][fish.y] > 0 && map[fish.x][fish.y] < babyShark.size) {
                fishes.add(fish);
                dist = fish.dist;
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = fish.x + dx[i];
                int ny = fish.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny] && map[nx][ny] <= babyShark.size) {
                        queue.offer(new Fish(nx, ny, fish.dist + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        if (fishes.size() == 0) return null;
        Collections.sort(fishes, new Comparator<Fish>() {
            public int compare(Fish f1, Fish f2) {
                if (f1.x == f2.x) return f1.y - f2.y;
                else return f1.x - f2.x;
            }
        });
        return fishes.get(0);
    }
}