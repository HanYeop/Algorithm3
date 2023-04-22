import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// [백준] 1781. 컵라면 (Java)
class Node implements Comparable<Node>{
    int index, value;

    Node(int index, int value){
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
//        // 컵라면 가치 내림차순
//        if(this.index == o.index){
//            return o.value - this.value;
//        }
//        // 인덱스 내림차순
//        return o.index - this.index;
        return o.index - this.index;
    }
}

public class Main {

    static int n;
    static PriorityQueue<Node> pq;
    static PriorityQueue<Integer> cups;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        cups = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            pq.offer(new Node(index, value));
        }

        for(int i = n; i >= 1; i--) {
            while (!pq.isEmpty()) {
                Node cur = pq.peek();

                // 현재 불가능한 문제
                if (cur.index < i) {
                    break;
                }

                pq.poll();
                cups.offer(cur.value);
            }

            if(!cups.isEmpty()){
                result += cups.poll();
            }
        }

        System.out.println(result);
    }
}