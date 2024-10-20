public class Main {
    public static void main(String[] args) {
        int[] num = new int[10000];

        for (int i = 1; i <= 10000; i++) {
            int index = i + i % 10 + i / 10 % 10 + i / 100 % 10 + i / 1000 % 10;
            if (index <= 10000)
                num[index - 1]++;
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 0) {
                System.out.println(i + 1);
            }
        }
    }
}