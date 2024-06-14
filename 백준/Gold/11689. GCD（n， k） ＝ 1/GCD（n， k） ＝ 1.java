

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());

        BigInteger result = n;
        for (BigInteger i = BigInteger.valueOf(2); i.multiply(i).compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            if (n.mod(i).equals(BigInteger.ZERO)) {
                while (n.mod(i).equals(BigInteger.ZERO)) {
                    n = n.divide(i);
                }
                result = result.subtract(result.divide(i));
            }
        }

        if (n.compareTo(BigInteger.ONE) > 0) {
            result = result.subtract(result.divide(n));
        }

        System.out.println(result);
    }
}