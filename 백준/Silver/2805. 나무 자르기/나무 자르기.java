import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int num2 = s.nextInt();
		int[] p = new int[num];
		int min = 0;
		int max = 0;
		for (int i = 0; i < num; i++) {
			p[i] = s.nextInt();
			if (max < p[i]) {
				max = p[i];
			}
		}
		while (min < max) {
			int mid = (min + max) / 2;
			long sum = 0;
			for (int tree : p) {
				if (tree - mid > 0) {
					sum += (tree - mid);
				}
			}
			if (sum < num2) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}
}