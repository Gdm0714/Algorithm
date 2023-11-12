package Section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordInSentence {
    public static String solution(String s){
        String [] text = s.split(" ");
        int index = 0;
        for(int i = 0; i<text.length; i++)
            if(text[index].length() < text[i].length())
                index = i;

        return text[index];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }
}
