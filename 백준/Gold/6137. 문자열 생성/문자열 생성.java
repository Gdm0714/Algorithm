import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        char[] s = new char[n];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine().charAt(0);
        }
        
        StringBuilder result = new StringBuilder();
        int left = 0;
        int right = n - 1;
        
        while (left <= right) {
            if (s[left] < s[right]) {
                result.append(s[left]);
                left++;
            } else if (s[left] > s[right]) {
                result.append(s[right]);
                right--;
            } else {
                if (shouldTakeLeft(s, left, right)) {
                    result.append(s[left]);
                    left++;
                } else {
                    result.append(s[right]);
                    right--;
                }
            }
        }
        
        String output = result.toString();
        for (int i = 0; i < output.length(); i += 80) {
            int end = Math.min(i + 80, output.length());
            System.out.println(output.substring(i, end));
        }
    }
    
    private static boolean shouldTakeLeft(char[] s, int left, int right) {
        int i = left;
        int j = right;
        
        while (i <= j) {
            if (s[i] < s[j]) {
                return true;
            } else if (s[i] > s[j]) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}