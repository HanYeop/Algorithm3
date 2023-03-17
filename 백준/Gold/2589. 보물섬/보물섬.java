import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 2589. 보물섬 (Java)
class Node{
    int x,y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n,m;
    static char[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // 육지면 탐색 시작
                if(map[i][j] == 'L'){
                    visited = new boolean[n][m];
                    bfs(new Node(i,j));
                }
            }
        }

        System.out.println(max);
    }

    static void bfs(Node start){
        Queue<Node> queue = new LinkedList<>();

        int count = -1;
        queue.offer(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()){
            int size = queue.size();

            // 현재 레벨 원소 반복
            for(int i = 0; i < size; i++){
                Node cur = queue.poll();
                int x = cur.x;
                int y = cur.y;

                for(int j = 0; j < 4; j++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    // 범위 벗어남
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                        continue;
                    }

                    // 이미 방문
                    if(visited[nx][ny]){
                        continue;
                    }

                    // 물 못 지나감
                    if(map[nx][ny] == 'W'){
                        continue;
                    }

                    queue.offer(new Node(nx,ny));
                    visited[nx][ny] = true;
                }
            }

            count++;
        }

//        System.out.println(start.x + " " + start.y + " c:" + count);
        max = Math.max(max, count);
    }
}