import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<BigInteger> numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String number = "";
            for (char c : line.toCharArray()) {
                if (Character.isDigit(c)) {
                    number += c;
                } else if (!number.isEmpty()) {
                    numbers.add(new BigInteger(number));
                    number = "";
                }
            }
            if (!number.isEmpty()) {
                numbers.add(new BigInteger(number));
            }
        }

        Collections.sort(numbers);

        for (BigInteger number : numbers) {
            System.out.println(number);
        }
    }
}