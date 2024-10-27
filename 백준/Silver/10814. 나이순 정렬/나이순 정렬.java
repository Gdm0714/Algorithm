import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		String person[][] = new String[num][2];
		for (int i = 0; i < num; i++) {
			person[i][0] = s.next();
			person[i][1] = s.next();
		}
		Arrays.sort(person, new Comparator<String[]>() {
			@Override
			public int compare(String[] a, String[] b) {
				return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
			}
		});
		for (int i = 0; i < num; i++) {
			System.out.println(person[i][0] + " " + person[i][1]);
		}
	}
}
