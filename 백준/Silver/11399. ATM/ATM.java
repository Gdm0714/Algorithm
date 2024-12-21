import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int[] p = new int[num];
		for (int i = 0; i < num; i++) {
			p[i] = s.nextInt();
		}
		Arrays.sort(p);
		int sum = 0;
		int n = 0;
		for (int i = 0; i < num; i++) {
			n += p[i];
			sum += n;
		}
		System.out.println(sum);
	}
}
