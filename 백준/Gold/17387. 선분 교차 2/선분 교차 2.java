import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());
        boolean cross = isIntersect(x1, y1, x2, y2, x3, y3, x4, y4);
        if (cross) System.out.println(1);
        else System.out.println(0);
    }
    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long temp = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * + y2 + x1 *y3);
        if(temp > 0) return 1;
        else if(temp < 0) return -1;
        return 0;
    }
    private static boolean isIntersect(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        int abc = ccw(x1, y1, x2, y2, x3, y3);
        int abd = ccw(x1, y1, x2, y2, x4, y4);
        int cda = ccw(x3, y3, x4, y4, x1, y1);
        int cdb = ccw(x3, y3, x4, y4, x2, y2);
        if (abc * abd == 0 && cda * cdb == 0) {
            if(Math.min(x1,  x2) <= Math.max(x3,  x4) && Math.min(x3,  x4) <= Math.max(x1,  x2)
                    && Math.min(y1,  y2) <= Math.max(y3,  y4) && Math.min(y3,  y4) <= Math.max(y1,  y2)) return true;
            return false;
        } else if (abc * abd <= 0 && cda * cdb <= 0) {
            return true;
        }
        return false;
    }
}