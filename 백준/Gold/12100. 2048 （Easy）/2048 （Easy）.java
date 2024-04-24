import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] num;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(max);
    }

    static void dfs(int cnt) {
        if (cnt == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, num[i][j]);
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] sw = new int[n][n];
            switch (i) {
                case 0:
                    for (int j = 0; j < n; j++) {
                        int idx = 0;
                        boolean visited = false;
                        for (int k = 0; k < n; k++) {
                            if (num[j][k] != 0) {
                                if (idx == 0) {
                                    sw[j][idx] = num[j][k];
                                    idx++;
                                } else {
                                    if (!visited && sw[j][idx - 1] == num[j][k]) {
                                        sw[j][idx - 1] *= 2;
                                        visited = true;
                                    } else {
                                        sw[j][idx] = num[j][k];
                                        visited = false;
                                        idx++;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 1:
                    for (int j = 0; j < n; j++) {
                        int idx = n - 1;
                        boolean visited = false;
                        for (int k = n - 1; k >= 0; k--) {
                            if (num[j][k] != 0) {
                                if (idx == n - 1) {
                                    sw[j][idx] = num[j][k];
                                    idx--;
                                } else {
                                    if (!visited && sw[j][idx + 1] == num[j][k]) {
                                        sw[j][idx + 1] *= 2;
                                        visited = true;
                                    } else {
                                        sw[j][idx] = num[j][k];
                                        visited = false;
                                        idx--;
                                    }
                                }
                            }
                        }
                    }
                    break;
                // 왼쪽으로 움직임
                case 2:
                    for (int j = 0; j < n; j++) {
                        int idx = 0;
                        boolean visited = false;
                        for (int k = 0; k < n; k++) {
                            // 현재 위치의 값이 0이 아닌경우 위치를 옮겨야함
                            if (num[k][j] != 0) {
                                if (idx == 0) {
                                    // 처음으로 움직이는 값인 경우
                                    sw[idx][j] = num[k][j];
                                    idx++;
                                } else {
                                    if (!visited && sw[idx - 1][j] == num[k][j]) {
                                        // 그 전 값이 합쳐지지 않았고 두 값이 같은 경우 합쳐야합니다.
                                        sw[idx - 1][j] *= 2;
                                        visited = true;
                                    } else {
                                        sw[idx][j] = num[k][j];
                                        visited = false;
                                        idx++;
                                    }
                                }
                            }
                        }
                    }
                    break;
                // 오른쪽으로 움직임
                case 3:
                    for (int j = 0; j < n; j++) {
                        int idx = n - 1;
                        boolean visited = false;
                        for (int k = n - 1; k >= 0; k--) {
                            // 현재 위치의 값이 0이 아닌경우 위치를 옮겨야함
                            if (num[k][j] != 0) {
                                if (idx == n - 1) {
                                    // 처음으로 움직이는 값인 경우
                                    sw[idx][j] = num[k][j];
                                    idx--;
                                } else {
                                    if (!visited && sw[idx + 1][j] == num[k][j]) {
                                        // 그 전 값이 합쳐지지 않았고 두 값이 같은 경우 합쳐야합니다.
                                        sw[idx + 1][j] *= 2;
                                        visited = true;
                                    } else {
                                        sw[idx][j] = num[k][j];
                                        visited = false;
                                        idx--;
                                    }
                                }
                            }
                        }
                    }
            }

            int[][] tmp = new int[n][n];
            for (int j = 0; j < n; j++) {
                tmp[j] = num[j].clone();
            }
            num = sw;
            dfs(cnt + 1);
            num = tmp;
        }
    }
}