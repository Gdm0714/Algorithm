import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int n = s.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= num; i++) {
			q.add(i);
		}
		StringBuilder sb = new StringBuilder("<");
		int count = 0;
		while (q.size() > 1) {
			count++;
			if (count == n) {
				sb.append(q.poll()).append(", ");
				count = 0;
			} else {
				q.add(q.poll());
			}
		}
		sb.append(q.poll());
		sb.append(">");
		System.out.println(sb);
	}
}
