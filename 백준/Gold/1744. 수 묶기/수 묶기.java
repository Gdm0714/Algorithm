
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        boolean isZero = false;
        int oneCnt = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                pos.add(num);
            } else if (num < 0) {
                neg.add(num);
            } else if (num == 0) {
                isZero = true;
            } else {
                oneCnt++;
            }
        }

        pos.sort(Collections.reverseOrder());
        neg.sort(Integer::compareTo);
        int result = oneCnt;

        for (int i = 0; i < pos.size(); i += 2) {
            if (i + 1 < pos.size()) {
                result += pos.get(i) * pos.get(i + 1);
            } else {
                result += pos.get(i);
            }
        }

        for (int i = 0; i < neg.size(); i += 2) {
            if (i + 1 < neg.size()) {
                result += neg.get(i) * neg.get(i + 1);
            } else {
                if (isZero) {
                    continue;
                } else {
                    result += neg.get(i);
                }
            }
        }
        System.out.println(result);
    }
}
