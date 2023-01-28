package etc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String text = s.next();

        String[] alp = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        int cnt = 0;
        for (int j = 0; j < alp.length; j++) {
            while (text.contains(alp[j])) {
                text = text.replace(alp[j], "ㅂ");
            }
        }
        cnt += text.length();

        System.out.println(cnt);
    }
}
