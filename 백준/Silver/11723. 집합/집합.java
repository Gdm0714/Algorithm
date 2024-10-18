import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int bitmask = 0;
		while (num-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String text = st.nextToken();
			int n;
			switch (text) {
			case "add":
				n = Integer.parseInt(st.nextToken());
				bitmask = bitmask | 1 << (n - 1);
				break;
			case "remove":
				n = Integer.parseInt(st.nextToken());
				bitmask = bitmask & ~(1 << (n - 1));
				break;
			case "check":
				n = Integer.parseInt(st.nextToken());
				sb.append(((bitmask & 1 << (n - 1)) == 1 << (n - 1) ? 1 : 0) + "\n");
				break;
			case "toggle":
				n = Integer.parseInt(st.nextToken());
				bitmask = bitmask ^ 1 << (n - 1);
				break;
			case "all":
				bitmask = ~0;
				break;
			case "empty":
				bitmask = 0;
				break;

			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
