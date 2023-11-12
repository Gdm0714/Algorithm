package Section1;

import java.io.*;

public class FindCharacter {
    public static int solution(String s, char s2){
        int cnt = 0;
        for(int i = 0; i<s.length(); i++)
            if(s.toLowerCase().charAt(i) == s2 || s.toUpperCase().charAt(i) == s2)
                cnt++;

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char s2 = br.readLine().charAt(0);
        System.out.println(solution(s, s2));
    }

}
