import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// [백준] 1972. 최소 힙 (Java)
public class Main {

    static int n;
    static PriorityQueue<Integer> pq;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        sb = new StringBuilder();

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