package etc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        int result = 0;

        for (int i = 0; i < num; i++) {
            String text = s.next();
            int cnt = 0;
            for (int j = 0; j < text.length() - 1; j++) {
                if (text.charAt(j) != text.charAt(j + 1)) {
                    for (int k = j + 2; k < text.length(); k++) {
                        if (text.charAt(j) == text.charAt(k)) {
                            cnt++;
                        }
                    }
                }
            }
            if (cnt == 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}
