import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int[][] p = new int[num][2];
		for (int i = 0; i < num; i++) {
			p[i][0] = s.nextInt();
			p[i][1] = s.nextInt();
		}
		Arrays.sort(p, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			} else {
				return a[1] - b[1];
			}
		});
		for (int i = 0; i < num; i++) {
			System.out.println(p[i][0] + " " + p[i][1]);
		}
	}
}
