import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [백준] 2573. 빙산 (Java)
public class Main {

    static int n,m;
    static int[][] map;
    static int[][] tmpMap;
    static int time; // 걸린 시간
    static int count; // 현재 빙산 개수

    // 탐색 시작할 위치
    static int startX;
    static int startY;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (startX != -1) {
            time++;
            tmpMap = new int[n][m];
            count = 0;
            startX = -1;
            startY = -1;

            // 빙산 녹음
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    nextTime(i, j);
                }
            }

            // 녹은 상태 저장
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    // 녹아도 바다가 되지 않은 빙산들 체크
                    if((map[i][j] += tmpMap[i][j]) > 0){
                        count++;
                        // 빙산이 아직 다 녹지 않음
                        if(startX == -1){
                            startX = i;
                            startY = j;
                        }
                    }
                }
            }

            // 분리됐는지 확인
            if(isSplit()){
                break;
            }
        }

        // 다 녹을때까지 분리되지 않은 경우
        if (startX == -1) {
            System.out.println(0);
        }else{
            System.out.println(time);
        }
    }

    static void nextTime(int x, int y) {
        int cur = map[x][y];

        // 이미 바다면 수행하지 않음
        if (cur <= 0) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 닿는 면이 바다면
            if (map[nx][ny] <= 0) {
                --tmpMap[x][y];
            }
        }
    }

    static boolean isSplit(){
        if(startX == -1){
            return true;
        }

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        qx.offer(startX);
        qy.offer(startY);
        visited[startX][startY] = true;

        while (!qx.isEmpty()){
            int curX = qx.poll();
            int curY = qy.poll();
            count--;

            for(int i = 0; i < 4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 이미 방문
                if(visited[nx][ny]){
                    continue;
                }

                // 바다
                if(map[nx][ny] <= 0){
                    continue;
                }

                visited[nx][ny] = true;
                qx.offer(nx);
                qy.offer(ny);
            }
        }

        return count != 0;
    }
}