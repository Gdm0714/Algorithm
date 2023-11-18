package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class PrintBigInteger {
    public static ArrayList<Integer> solution(int []num){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(num[0]);
        for(int i = 1; i<num.length; i++){
            if(num[i]>num[i-1])
                result.add(num[i]);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int []num = new int[n];
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> result = solution(num);
        Iterator<Integer> it = result.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }

}
