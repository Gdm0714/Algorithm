import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        int[] inDegree = new int[n + 1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            inDegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++){
            if(inDegree[i] == 0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int node = pq.poll();
            System.out.print(node + " ");
            for(int i : list.get(node)){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    pq.add(i);
                }
            }
        }
    }
}