package etc;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();

        int cnt = 0;

        int num2 = 0;

        while (num2 < num) {
            cnt++;
            num2 = cnt * (cnt + 1) / 2;
        }

        int parent;
        int child;

        if (cnt % 2 != 0) {
            parent = cnt;
            child = 1;
            for (int i = 0; i < num2 - num; i++) {
                child++;
                parent--;
            }
        } else {
            parent = 1;
            child = cnt;
            for (int i = 0; i < num2 - num; i++) {
                parent++;
                child--;
            }
        }
        System.out.println(child + "/" + parent);
    }
}
