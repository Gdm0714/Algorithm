import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int start = 0;
            int end = s.length() - 1;
            boolean isPal = true;
            boolean isPal2 = false;

            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    isPal = false;
                    if (isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1)) isPal2 = true;
                    break;
                }
                start++;
                end--;
            }
            if (isPal) System.out.println(0);
            else if (isPal2) System.out.println(1);
            else System.out.println(2);
        }
    }

    static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}