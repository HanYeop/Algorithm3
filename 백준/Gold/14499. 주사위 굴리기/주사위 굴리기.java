import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 14499. 주사위 굴리기 (Java)
public class Main {

    static int n,m; // 지도 세로 가로 크기
    static int x,y; // 주사위 좌표
    static int k; // 명령 개수
    static int[][] map; // 지도
    static int[] dice; // 주사위 정보
    static StringBuilder sb;

    // 1234 => 동서북남
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dice = new int[6];
        sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            solve(Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb);
    }

    static void solve(int dir){
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        // 범위 벗어나는 경우 아무 행동X
        if(nx < 0 || ny < 0 || nx >= n || ny >= m){
            return;
        }

        // 임시 주사위 정보 생성
        int[] newDice = new int[6];
        for(int i = 0; i < 6; i++){
            newDice[i] = dice[i];
        }

        // 맨 위, 맨 아래
        int top = 3;
        int bottom = 1;

        // 동쪽
        if (dir == 1){
            newDice[1] = dice[5];
            newDice[3] = dice[4];
            newDice[4] = dice[1];
            newDice[5] = dice[3];
        }
        // 서쪽
        else if(dir == 2){
            newDice[1] = dice[4];
            newDice[3] = dice[5];
            newDice[4] = dice[3];
            newDice[5] = dice[1];
        }
        // 북쪽
        else if(dir == 3){
            newDice[0] = dice[3];
            newDice[1] = dice[0];
            newDice[2] = dice[1];
            newDice[3] = dice[2];
        }
        // 남쪽
        else if(dir == 4){
            newDice[0] = dice[1];
            newDice[1] = dice[2];
            newDice[2] = dice[3];
            newDice[3] = dice[0];
        }

        // 이동 완료
        dice = newDice;
        x = nx;
        y = ny;

        // 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다
        if(map[x][y] == 0){
            map[x][y] = dice[bottom];
        }

        // 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
        else{
            dice[bottom] = map[x][y];
            map[x][y] = 0;
        }

        sb.append(dice[top]).append("\n");
    }
}