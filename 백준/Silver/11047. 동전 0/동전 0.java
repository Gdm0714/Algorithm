import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[] p = new int[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			p[i] = s.nextInt();
		}
		for (int i = n - 1; i > -1; i--) {
			if (p[i] <= m) {
				count += (m / p[i]);
				m %= p[i];
			}
		}
		System.out.println(count);
	}
}
