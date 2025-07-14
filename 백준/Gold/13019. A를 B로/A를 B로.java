import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        if (!canMake(A, B)) {
            System.out.println(-1);
            return;
        }

        int n = A.length();
        int aIdx = n - 1;
        int bIdx = n - 1;
        int cnt = 0;

        while (aIdx >= 0 && bIdx >= 0) {
            if (A.charAt(aIdx) == B.charAt(bIdx)) {
                cnt++;
                bIdx--;
            }
            aIdx--;
        }
        System.out.println(n - cnt);
    }

    private static boolean canMake(String A, String B) {
        if (A.length() != B.length())
            return false;

        int[] ACnt = new int[26];
        int[] BCnt = new int[26];

        for (int i = 0; i < A.length(); i++) {
            ACnt[A.charAt(i) - 'A']++;
            BCnt[B.charAt(i) - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (ACnt[i] != BCnt[i])
                return false;
        }
        return true;
    }
}
