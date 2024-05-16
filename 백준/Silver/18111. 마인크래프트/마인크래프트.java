import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int num3 = Integer.parseInt(st.nextToken());
		int[][] ground = new int[num][num2];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < ground.length; i++) {
			String[] Row = br.readLine().split(" ");
			for (int j = 0; j < num2; j++) {
				int value = Integer.parseInt(Row[j]);
				ground[i][j] = value;
				max = Math.max(max, value);
				min = Math.min(min, value);
			}
		}
		int se = Integer.MAX_VALUE;
		int height = -1;
		for (int i = min; i <= max; i++) {
			int second = 0;
			int in = num3;
			for (int j = 0; j < ground.length; j++) {
				for (int k = 0; k < ground[j].length; k++) {
					int n = ground[j][k] - i;
					if (n > 0) {
						second += Math.abs(n) * 2;
						in += Math.abs(n);
					} else if (n < 0) {
						second += Math.abs(n);
						in -= Math.abs(n);
					}
				}
			}
			if (in >= 0) {
				if (second <= se) {
					se = second;
					height = i;
				}
			}
		}
		bw.write(se + " " + height);
		bw.flush();
        bw.close();
	}
}
