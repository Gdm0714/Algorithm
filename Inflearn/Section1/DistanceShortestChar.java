package section1;

import java.util.Scanner;


    public class DistanceShortestChar {
        public static int[] solution(String s, char t){
            int[] distances = new int[s.length()];
            int tIndex = -1;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == t) {
                    tIndex = i;
                }

                if (tIndex == -1) {
                    distances[i] = Integer.MAX_VALUE;
                } else {
                    distances[i] = Math.abs(i - tIndex);
                }
            }

            tIndex = -1;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == t) {
                    tIndex = i;
                }

                if (tIndex != -1) {
                    distances[i] = Math.min(distances[i], Math.abs(i - tIndex));
                }
            }



            return distances;
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String s = scanner.next();
            char t = scanner.next().charAt(0);
            int []distances = solution(s, t);
            for (int distance : distances) {
                System.out.print(distance + " ");
            }
        }
    }


