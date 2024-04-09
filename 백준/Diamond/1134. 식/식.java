

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int cToI(char c) {
        if (c == '?')
            return -1;
        return c - '0';
    }

    public static List<List<Integer>> candidate(int aIn, int bIn, int cIn, int carryIn, int carryOut) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> aList, bList, cList;

        if (aIn == -1)
            aList = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        else
            aList = List.of(aIn);

        if (bIn == -1)
            bList = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        else
            bList = List.of(bIn);

        if (cIn == -1)
            cList = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        else
            cList = List.of(cIn);

        for (int a : aList) {
            for (int b : bList) {
                for (int c : cList) {
                    if (a + b + carryIn - c == 10 * carryOut) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(a);
                        temp.add(b);
                        temp.add(c);
                        ret.add(temp);
                    }
                }
            }
        }
        return ret;
    }

    public static BigInteger valList(List<Integer> list) {
        BigInteger b = new BigInteger("-1");
        if (list.isEmpty())
            return b;
        String s = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            s+=list.get(i);
        }
        s = s.replaceAll("[^0-9]", ""); // 숫자가 아닌 모든 문자를 제거
        return new BigInteger(s.trim());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String exp = br.readLine();

        StringTokenizer st1 = new StringTokenizer(exp, "+=");
        String A = new StringBuilder(st1.nextToken()).reverse().toString();
        String B = new StringBuilder(st1.nextToken()).reverse().toString();
        String C = new StringBuilder(st1.nextToken()).reverse().toString();

        int len = Math.max(A.length(), B.length());
        int oneA = A.length() - 1;
        int oneB = B.length() - 1;

        if (oneA == 0)
            oneA = -1;
        if (oneB == 0)
            oneB = -1;

        A = A + "0".repeat(Math.max(0, len - A.length()));
        B = B + "0".repeat(Math.max(0, len - B.length()));

        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        List<Integer> cList = new ArrayList<>();

        for (char c : A.toCharArray()) {
            aList.add(cToI(c));
        }

        for (char c : B.toCharArray()) {
            bList.add(cToI(c));
        }

        for (char c : C.toCharArray()) {
            cList.add(cToI(c));
        }

        if (cList.size() != len + 1 && cList.size() != len) {
            System.out.println("-1");
            return;
        }

        List<Integer> Ac = new ArrayList<>();
        List<Integer> Bc = new ArrayList<>();
        List<Integer> Cc = new ArrayList<>();
        List<Integer> An = new ArrayList<>();
        List<Integer> Bn = new ArrayList<>();
        List<Integer> Cn = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            List<Integer> anBefore = new ArrayList<>(An);
            List<Integer> bnBefore = new ArrayList<>(Bn);
            List<Integer> cnBefore = new ArrayList<>(Cn);
            List<Integer> acBefore = new ArrayList<>(Ac);
            List<Integer> bcBefore = new ArrayList<>(Bc);
            List<Integer> ccBefore = new ArrayList<>(Cc);

            List<Integer> anMx = new ArrayList<>();
            List<Integer> bnMx = new ArrayList<>();
            List<Integer> cnMx = new ArrayList<>();

            if (An.size() == i) {
                List<List<Integer>> cand = candidate(aList.get(i), bList.get(i), cList.get(i), 0, 0);
                for (List<Integer> val : cand) {
                    if (oneA == i && val.get(0) == 0)
                        continue;
                    if (oneB == i && val.get(1) == 0)
                        continue;
                    List<Integer> anTmp = new ArrayList<>(anBefore);
                    List<Integer> bnTmp = new ArrayList<>(bnBefore);
                    List<Integer> cnTmp = new ArrayList<>(cnBefore);
                    anTmp.add(val.get(0));
                    bnTmp.add(val.get(1));
                    cnTmp.add(val.get(2));
                    BigInteger ccTmpVal = valList(cnTmp);
                    if (ccTmpVal.compareTo(valList(cnMx)) > 0 || (ccTmpVal.compareTo(valList(cnMx)) == 0 && valList(anTmp).compareTo(valList(anMx)) > 0)) {
                        anMx = new ArrayList<>(anTmp);
                        bnMx = new ArrayList<>(bnTmp);
                        cnMx = new ArrayList<>(cnTmp);
                    }
                }
            }

            if (Ac.size() == i && i != 0) {
                List<List<Integer>> cand = candidate(aList.get(i), bList.get(i), cList.get(i), 1, 0);
                for (List<Integer> val : cand) {
                    if (oneA == i && val.get(0) == 0)
                        continue;
                    if (oneB == i && val.get(1) == 0)
                        continue;
                    List<Integer> anTmp = new ArrayList<>(acBefore);
                    List<Integer> bnTmp = new ArrayList<>(bcBefore);
                    List<Integer> cnTmp = new ArrayList<>(ccBefore);
                    anTmp.add(val.get(0));
                    bnTmp.add(val.get(1));
                    cnTmp.add(val.get(2));
                    BigInteger ccTmpVal = valList(cnTmp);
                    if (ccTmpVal.compareTo(valList(cnMx)) > 0 || (ccTmpVal.compareTo(valList(cnMx)) == 0 && valList(anTmp).compareTo(valList(anMx)) > 0)) {
                        anMx = new ArrayList<>(anTmp);
                        bnMx = new ArrayList<>(bnTmp);
                        cnMx = new ArrayList<>(cnTmp);
                    }
                }
            }

            List<Integer> acMx = new ArrayList<>();
            List<Integer> bcMx = new ArrayList<>();
            List<Integer> ccMx = new ArrayList<>();

            if (An.size() == i) {
                List<List<Integer>> cand = candidate(aList.get(i), bList.get(i), cList.get(i), 0, 1);
                for (List<Integer> val : cand) {
                    if (oneA == i && val.get(0) == 0)
                        continue;
                    if (oneB == i && val.get(1) == 0)
                        continue;
                    List<Integer> acTmp = new ArrayList<>(anBefore);
                    List<Integer> bcTmp = new ArrayList<>(bnBefore);
                    List<Integer> ccTmp = new ArrayList<>(cnBefore);
                    acTmp.add(val.get(0));
                    bcTmp.add(val.get(1));
                    ccTmp.add(val.get(2));
                    BigInteger ccTmpVal = valList(ccTmp);
                    if (ccTmpVal.compareTo(valList(ccMx)) > 0 || (ccTmpVal.compareTo(valList(ccMx)) == 0 && valList(acTmp).compareTo(valList(acMx)) > 0)){
                        acMx = new ArrayList<>(acTmp);
                        bcMx = new ArrayList<>(bcTmp);
                        ccMx = new ArrayList<>(ccTmp);
                    }
                }
            }

            if (Ac.size() == i && i != 0) {
                List<List<Integer>> cand = candidate(aList.get(i), bList.get(i), cList.get(i), 1, 1);
                for (List<Integer> val : cand) {
                    if (oneA == i && val.get(0) == 0)
                        continue;
                    if (oneB == i && val.get(1) == 0)
                        continue;
                    List<Integer> acTmp = new ArrayList<>(acBefore);
                    List<Integer> bcTmp = new ArrayList<>(bcBefore);
                    List<Integer> ccTmp = new ArrayList<>(ccBefore);
                    acTmp.add(val.get(0));
                    bcTmp.add(val.get(1));
                    ccTmp.add(val.get(2));
                    BigInteger ccTmpVal = valList(ccTmp);
                    if (ccTmpVal.compareTo(valList(ccMx)) > 0 || (ccTmpVal.compareTo(valList(ccMx)) == 0 && valList(acTmp).compareTo(valList(acMx)) > 0)) {
                        acMx = new ArrayList<>(acTmp);
                        bcMx = new ArrayList<>(bcTmp);
                        ccMx = new ArrayList<>(ccTmp);
                    }
                }
            }

            Ac = new ArrayList<>(acMx);
            Bc = new ArrayList<>(bcMx);
            Cc = new ArrayList<>(ccMx);
            An = new ArrayList<>(anMx);
            Bn = new ArrayList<>(bnMx);
            Cn = new ArrayList<>(cnMx);
        }

        if (cList.size() == len + 1) {
            if (cList.get(len) != -1 && cList.get(len) != 1) {
                System.out.println(-1);
                return;
            }
            if (Ac.size() != len) {
                System.out.println(-1);
                return;
            }
            Cc.add(1);
            System.out.printf("%d+%d=%d%n", valList(Ac), valList(Bc), valList(Cc));
            return;
        }

        if (An.size() != len) {
            System.out.println(-1);
            return;
        }
        System.out.printf("%d+%d=%d%n", valList(An), valList(Bn), valList(Cn));
    }
}


