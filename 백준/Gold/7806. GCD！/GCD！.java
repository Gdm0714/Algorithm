import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            if (n == 0 && k == 0) break;

            ArrayList<Pair> factors = new ArrayList<>();

            for (long p = 2; p * p <= k; p++) {
                int cnt = 0;
                while (k % p == 0) {
                    cnt++;
                    k /= p;
                }
                if (cnt != 0) {
                    factors.add(new Pair(p, cnt));
                }
            }
            if (k != 1) {
                factors.add(new Pair(k, 1));
            }

            long res = 1;

            for (int i = factors.size() - 1; i >= 0; i--) {
                if (factors.get(i).first <= n) {
                    if (factors.get(i).second == 1) {
                        if (factors.get(i).first <= n) {
                            res *= factors.get(i).first;
                        }
                    } else {
                        int primeCount = 0;
                        long pp = factors.get(i).first;
                        while (pp <= n) {
                            primeCount += n / pp;
                            pp *= factors.get(i).first;
                        }
                        int minn = Math.min(primeCount, factors.get(i).second);
                        for (int j = 0; j < minn; j++) {
                            res *= factors.get(i).first;
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }

    static class Pair {
        long first;
        int second;

        Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}