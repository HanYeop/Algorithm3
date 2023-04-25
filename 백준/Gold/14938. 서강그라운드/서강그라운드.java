import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// [백준] 14938. 서강그라운드 (Java)
class Node implements Comparable<Node>{
    int des, value;

    Node(int des, int value){
        this.des = des;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
public class Main {

    static int n,m,r;
    static int[] item;
    static ArrayList<Node>[] lists;
    static int[][] dist;
    final static int INF = 1000000;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        item = new int[n + 1];
        lists = new ArrayList[n + 1];
        dist = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            item[i] = Integer.parseInt(st.nextToken());
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if(i != j){
                    dist[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            lists[one].add(new Node(two, value));
            lists[two].add(new Node(one, value));
        }

        for(int i = 1; i <= n; i++){
            PriorityQueue<Node> pq = new PriorityQueue<>();

            for(Node node: lists[i]){
                // 수색 범위 초과
                if(node.value > m){
                    continue;
                }
                pq.offer(node);
            }

            while (!pq.isEmpty()){
                Node cur = pq.poll();

                if(cur.value < dist[i][cur.des]){
                    dist[i][cur.des] = cur.value;
                    for(Node node: lists[cur.des]){
                        int nextValue = node.value + cur.value;
                        // 수색 범위 초과
                        if(nextValue > m){
                            continue;
                        }
                        pq.offer(new Node(node.des, nextValue));
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = 1; j <= n; j++){
                if(dist[i][j] != INF){
                    sum += item[j];
                }
            }
            result = Math.max(sum, result);
        }

        System.out.println(result);
    }
}