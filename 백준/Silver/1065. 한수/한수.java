import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            if(i<100){
                cnt++;
            }
            else if(i<1000){
                if (i / 10 % 10 - i % 10 == i / 100 % 10 - i / 10 % 10) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}