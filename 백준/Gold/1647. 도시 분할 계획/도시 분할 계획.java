import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// [백준] 1647. 도시 분할 계획 (Java)
class Node implements Comparable<Node>{
    int index, value;

    Node(int index, int value){
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return this.index + " " + this.value;
    }
}

public class Main {

    static int n,m;
    static ArrayList<Node>[] house;
    static boolean[] visited;
    static PriorityQueue<Node> pq;
    static int result;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        house = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            house[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        pq = new PriorityQueue<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if(pq.isEmpty()){
                pq.offer(new Node(one, 0));
            }
            house[one].add(new Node(two, value));
            house[two].add(new Node(one, value));
        }

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.index]){
                continue;
            }

            visited[cur.index] = true;
            result += cur.value;
            max = Math.max(max, cur.value);

            for(Node node: house[cur.index]){
                if(!visited[node.index]){
                    pq.offer(node);
                }
            }
        }

        System.out.println(result - max);
    }
}