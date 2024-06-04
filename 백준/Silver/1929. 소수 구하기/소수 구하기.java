import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int i = num; i <= num2; i++) {
			boolean b = true;
			if (i == 1) {
				continue;
			}
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					b = false;
					break;
				}
			}
			if (b == true) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}
