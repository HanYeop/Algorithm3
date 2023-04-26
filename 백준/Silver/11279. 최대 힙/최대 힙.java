import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// [백준] 11279. 최대 힙 (Java)
public class Main {

    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            int cur = Integer.parseInt(br.readLine());
            if(cur == 0){
                if(pq.isEmpty()){
                    sb.append("0");
                }else{
                    sb.append(pq.poll());
                }
                sb.append("\n");
            }else{
                pq.offer(cur);
            }
        }

        System.out.println(sb);
    }
}