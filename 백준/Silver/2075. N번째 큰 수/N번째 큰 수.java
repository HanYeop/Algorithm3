import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// [백준] 2075. N번째 큰 수 (Java)
public class Main {

    static int n;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i < n - 1; i++){
            pq.poll();
        }

        System.out.println(pq.poll());
    }
}