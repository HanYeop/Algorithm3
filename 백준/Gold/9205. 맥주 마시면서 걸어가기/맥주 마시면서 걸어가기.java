import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [백준] 9205. 맥주 마시면서 걸어가기 (Java)
class Node{
    int x,y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }

}

public class Main {

    static int t;
    static int n;
    static Node start;
    static Node[] shop;
    static boolean[] visited;
    static Node end;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int T = 0; T < t; T++){
            n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            shop = new Node[n];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                shop[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            visited = new boolean[n];

            st = new StringTokenizer(br.readLine());
            end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            Queue<Node> q = new LinkedList<>();
            q.offer(start);
            while (!q.isEmpty()){
                Node cur = q.poll();

                // 목표 도달
                if(isDistance(cur, end)){
                    sb.append("happy");
                    q.offer(end);
                    break;
                }

                for(int i = 0; i < n; i++){
                    if(visited[i]){
                        continue;
                    }
                    Node next = shop[i];

                    if(isDistance(cur, next)){
                        visited[i] = true;
                        q.offer(next);
                    }
                }
            }

            if(q.isEmpty()) {
                sb.append("sad");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean isDistance(Node node1, Node node2){
        return Math.abs(node1.x - node2.x) + Math.abs(node1.y - node2.y) <= 1000;
    }
}