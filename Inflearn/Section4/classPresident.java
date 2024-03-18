package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class classPresident {
    public static char solution(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char result = ' ';
        int max = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(c[i], hashMap.getOrDefault(c[i], 0) + 1);
        }
        for (char ch : hashMap.keySet()) {
            if(hashMap.get(ch) > max){
                max = hashMap.get(ch);
                result = ch;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        System.out.println(solution(s));

    }
}
