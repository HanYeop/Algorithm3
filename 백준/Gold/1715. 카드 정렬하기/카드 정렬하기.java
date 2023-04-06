import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// [백준] 1715. 카드 정렬하기 (Java)
public class Main {

    static int n;
    static PriorityQueue<Integer> pq;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            int cur = Integer.parseInt(br.readLine());
            pq.offer(cur);
        }

        while (pq.size() >= 2){
            int num1 = pq.poll();
            int num2 = pq.poll();
            int sum = num1 + num2;

            result += sum;
            pq.offer(sum);
        }

        System.out.println(result);
    }
}