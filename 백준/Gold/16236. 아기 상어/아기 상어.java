import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int x,y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    // 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
    @Override
    public int compareTo(Node o) {
        if(this.x == o.x){
            return this.y - o.y;
        }else{
            return this.x - o.x;
        }
    }
}

// [백준] 16236. 아기 상어 (Java)
public class Main {

    static int n;
    static int[][] map;
    static boolean[][] visited; // 방문 여부
    static int shark = 2; // 아기 상어 크기
    static int count; // 성장 여부
    static int time; // 이동 시간

    // 상어 시작 위치
    static int startX;
    static int startY;

    // 상좌우하
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int value = Integer.parseInt(st.nextToken());

                // 아기상어 위치
                if(value == 9){
                    startX = i;
                    startY = j;
                }else{
                    map[i][j] = value;
                }
            }
        }
        solve();
        System.out.println(time);
    }

    static void solve(){
        // 상어 성장
        if(count == shark){
            shark++;
            count = 0;
        }

        visited = new boolean[n][n];
        visited[startX][startY] = true;

        // 찾았는지 여부
        boolean find = false;
        PriorityQueue<Node> findQueue = new PriorityQueue<>();

        // 탐색 좌표
        Queue<Integer> qx = new LinkedList();
        Queue<Integer> qy = new LinkedList();
        qx.offer(startX);
        qy.offer(startY);
        int level = 1;

        while (!qx.isEmpty()){
            int size = qx.size();

            // 사이즈만큼 반복시킴 (최소거리 구하기)
            for(int s = 0; s < size; s++) {
                int curX = qx.poll();
                int curY = qy.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    // 범위 초과
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                        continue;
                    }

                    // 이미 방문
                    if(visited[nx][ny]){
                        continue;
                    }

                    // 자신보다 큰 물고기
                    if(map[nx][ny] > shark){
                        continue;
                    }

                    // 자신보다 작은 물고기 먹음
                    if(map[nx][ny] > 0 && map[nx][ny] < shark){
                        find = true;
                        findQueue.offer(new Node(nx,ny));
                    }

                    qx.offer(nx);
                    qy.offer(ny);
                    visited[nx][ny] = true;
                }
            }

            // 우선순위에 따라 물고기 먹음
            if(find){
                Node result = findQueue.poll();
                startX = result.x;
                startY = result.y;
                map[startX][startY] = 0;
                count++;
                time += level;
                solve();
                return;
            }

            level++;
        }
    }
}