import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<>();
		int num = Integer.parseInt(br.readLine());
		for (int j = 0; j < num; j++) {
			
			String text = br.readLine();
			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				if (c == '(') {
					st.push(c);
				} else {
					if (st.empty()) {
						st.push(c);
						break;
					} else {
						st.pop();
					}
				}
			}
			if (st.empty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			st.clear();
		}
	}
}
