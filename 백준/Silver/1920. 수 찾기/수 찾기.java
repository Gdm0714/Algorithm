import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int[] n = new int[num];
		for (int i = 0; i < num; i++) {
			n[i] = s.nextInt();
		}
		Arrays.sort(n);
		int num2 = s.nextInt();

		for (int i = 0; i < num2; i++) {
			int n2 = s.nextInt();
			int start = 0;
			int end = n.length - 1;
			boolean b = false;
			while (start <= end) {
				int mid_index = (start + end) / 2;
				int mid = n[mid_index];
				if (mid > n2) {
					end = mid_index - 1;
				} else if (mid < n2) {
					start = mid_index + 1;
				}
				else {
					b = true;
					System.out.println(1);
					break;
				}
			}
			if(!b) {
				System.out.println(0);
			}
		}
	}
}
