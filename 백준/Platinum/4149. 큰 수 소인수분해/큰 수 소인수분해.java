import java.util.*;
import java.io.*;
public class Main {
    static final int MAX = 10000;
    static boolean[] isPrime = new boolean[MAX];
    static List<Integer> primes = new ArrayList<>();

    static {
        for (int i = 2; i < MAX; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i < MAX; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        for (int prime : primes) {
            if ((long)prime * prime > n) {
                break;
            }
            while (n % prime == 0) {
                System.out.println(prime);
                n /= prime;
            }
        }

        if (n > 1) {
            System.out.println(n);
        }
    }
}