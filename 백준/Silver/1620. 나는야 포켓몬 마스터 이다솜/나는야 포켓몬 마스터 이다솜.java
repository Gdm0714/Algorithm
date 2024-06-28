import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static boolean isNum(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		String[] p = new String[n + 1];
		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			hm.put(name, i);
			p[i] = name;
		}
		while (m-- > 0) {
			String text = br.readLine();
			if (isNum(text)) {
				int index = Integer.parseInt(text);
				sb.append(p[index]);
			} else {
				sb.append(hm.get(text));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
