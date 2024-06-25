import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static int lowerBound(int[] a, int key) {
		int low = 0;
		int high = a.length;

		while (low < high) {
			int mid = (low + high) / 2;
			if (key <= a[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	private static int upperBound(int[] a, int key) {
		int low = 0;
		int high = a.length;
		while (low < high) {
			int mid = (low + high) / 2;
			if (key < a[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int[] a = new int[num];
		for (int i = 0; i < num; i++) {
			a[i] = s.nextInt();
		}
		Arrays.sort(a);
		int n = s.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int key = s.nextInt();
			sb.append(upperBound(a, key) - lowerBound(a, key)).append(' ');
		}
		System.out.println(sb);
	}
}
