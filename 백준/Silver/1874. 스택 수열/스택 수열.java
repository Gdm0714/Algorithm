import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		int num = s.nextInt();
		int start = 0;
		while (num-- > 0) {
			int value = s.nextInt();
			if (value > start) {
				for (int i = start + 1; i <= value; i++) {
					st.push(i);
					sb.append('+').append('\n');
				}
				start = value;
			} else if (st.peek() != value) {
				System.out.println("NO");
				return;
			}
			st.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}
}
