import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// [백준] 2665. 미로만들기 (Java)
class Node implements Comparable<Node>{
    int x,y,value;

    Node(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
public class Main {

    static int n;
    static int[][] map;
    static int[][] dist;
    static PriorityQueue<Node> pq;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dist = new int[n][n];
        pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            String[] strings = br.readLine().split("");
            for(int j = 0; j < n; j++){
                int value = Integer.parseInt(strings[j]);
                // 검은방 흰방 숫자 반대로(검은방 개수 구하기 위해)
                if(value == 1){
                    map[i][j] = 0;
                }else{
                    map[i][j] = 1;
                }

                dist[i][j] = 200;
            }
        }

        pq.offer(new Node(0,0,0));
        dist[0][0] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curX = cur.x;
            int curY = cur.y;

            for(int i = 0; i < 4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 범위 벗어남
                if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                    continue;
                }

                int value = map[nx][ny] + dist[curX][curY];

                if(dist[nx][ny] > value){
                    dist[nx][ny] = value;
                    pq.offer(new Node(nx,ny,value));
                }
            }
        }

        System.out.println(dist[n - 1][n - 1]);
    }
}