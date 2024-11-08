import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			StringTokenizer str = new StringTokenizer(br.readLine());
			LinkedList<int []>l = new LinkedList<>();
			for(int j = 0 ;str.hasMoreTokens();j++) {
				l.add(new int[] {j, Integer.parseInt(str.nextToken())});
			}
			int count = 0;
			while(!l.isEmpty()) {
				int [] tmp = l.poll();
				boolean b = true;
				for(int j = 0; j<l.size(); j++) {
					if(tmp[1]<l.get(j)[1]) {
						l.add(tmp);
						for(int k = 0; k<j; k++) {
							l.add(l.poll());
						}
						b = false;
						break;
					}
				}
				if(b==false) {
					continue;
				}
				count++;
				if(tmp[0]==m) {
					break;
				}
				
			}
			sb.append(count).append("\n");
			
		}
		System.out.println(sb);
	}
}
