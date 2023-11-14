package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Palindrome {
    public static String solution(String s){
        Pattern pattern = Pattern.compile("[^A-Z]");
        Matcher matcher = pattern.matcher(s.toUpperCase());
        s = matcher.replaceAll("");
        StringBuilder sb = new StringBuilder(s);
        if(s.equals(sb.reverse().toString())){
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));

    }
}
