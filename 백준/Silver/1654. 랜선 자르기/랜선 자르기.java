import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int n = s.nextInt();
		int[] p = new int[num];
		long max = 0;
		for (int i = 0; i < num; i++) {
			p[i] = s.nextInt();
			if (max < p[i]) {
				max = p[i];
			}
		}
		max++;
		long min = 0;
		long mid = 0;
		while (min < max) {
			mid = (max + min) / 2;
			long count = 0;
			for (int i = 0; i < p.length; i++) {
				count += (p[i] / mid);
			}
			if (count < n) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}
}
