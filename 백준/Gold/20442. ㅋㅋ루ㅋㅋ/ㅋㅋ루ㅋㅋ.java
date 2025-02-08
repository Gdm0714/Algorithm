import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int cntK = 0;

        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> left = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'K') cntK++;
            else if (s.charAt(i) == 'R') left.add(cntK);
        }

        cntK = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'K') cntK++;
            else if (s.charAt(i) == 'R') right.add(cntK);
        }

        Collections.sort(right, Collections.reverseOrder());

        int max = 0;
        int start = 0;
        int end = right.size() - 1;

        while (start <= end) {
            int num = (end - start + 1) + (Math.min(left.get(start), right.get(end)) * 2);
            max = Math.max(max, num);

            if(left.get(start) < right.get(end)) start++;
            else end--;
        }

        System.out.println(max);
    }
}