import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] a = new int[num];
		double sum = 0;
		for (int i = 0; i < num; i++) {
			a[i] = Integer.parseInt(br.readLine());
			sum += a[i];
		}
		sum /= num;
		Arrays.sort(a);
		int low = 0;
		int high = a.length;
		int mid = (low + high) / 2;
		int n = a[mid];
		int mod = a[0];
		int count = 0;
		int max = -1;
		boolean b = false;
		for (int i = 0; i < num - 1; i++) {
			if (a[i] == a[i + 1]) {
				count++;
			} else {
				count = 0;
			}
			if (max < count) {
				max = count;
				mod = a[i];
				b = true;
			} else if (max == count && b == true) {
				mod = a[i];
				b = false;
			}
		}
		int n2 = a[num - 1] - a[0];
		System.out.println(Math.round(sum));
		System.out.println(n);
		System.out.println(mod);
		System.out.println(n2);
	}
}
