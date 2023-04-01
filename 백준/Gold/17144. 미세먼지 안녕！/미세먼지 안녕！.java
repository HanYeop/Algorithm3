import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 17144. 미세먼지 안녕! (Java)
public class Main {

    static int r,c,t;
    static int[][] map;
    static int up, down; // 공기청정기 좌표
    static boolean upFound; // 위쪽 공기청정기 찾았는지 여부
    static int result;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                int value = Integer.parseInt(st.nextToken());

                // 공기청정기 좌표 찾기
                if(value == -1){
                    if(upFound){
                        down = i;
                    }else{
                        up = i;
                        upFound = true;
                    }
                }

                map[i][j] = value;
            }
        }

        // t만큼 반복수행
        for(int i = 0; i < t; i++) {
            solveOne();
            solveTwo();
        }

//        for(int i = 0; i < r; i++){
//            for(int j = 0; j < c; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 총 미세먼지 계산
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] > 0){
                    result += map[i][j];
                }
            }
        }

        System.out.println(result);
    }

    // 1. 확산 과정
    static void solveOne(){
        // 확산 과정 진행할 임시 맵 생성
        int[][] tmpMap = new int[r][c];

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                // 미세먼지 있는 칸인 경우
                if(map[i][j] > 0){

                    int count = 0; // 확산된 방향 개수
                    int plus = map[i][j] / 5; // 확산되는 양은 Ar,c/5이고 소수점은 버림

                    // 사방 탐색
                    for(int q = 0; q < 4; q++){
                        int nx = i + dx[q];
                        int ny = j + dy[q];

                        // 범위 벗어남
                        if(nx < 0 || nx >= r || ny < 0 || ny >= c){
                            continue;
                        }

                        // 공기청정기 맞닿음
                        if(map[nx][ny] == -1){
                            continue;
                        }

                        // 확산
                        tmpMap[nx][ny] += plus;
                        count++;
                    }

                    // (r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수)
                    tmpMap[i][j] += map[i][j] - (plus * count);
                }
            }
        }

        // 확산 종료
        tmpMap[up][0] = -1;
        tmpMap[down][0] = -1;
        map = tmpMap;
    }

    // 2. 공기청정기 바람 작동 과정
    static void solveTwo(){
        // 공기청정기 바람 작동 과정 진행할 임시 맵 생성
        int[][] tmpMap = new int[r][c];

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                int value = map[i][j];

                // 오른쪽 방향
                if(i == up || i == down){
                    // 공기청정기 바로 옆
                    if(j == 1){
                        value = 0;
                    }
                    if(j >= 2){
                        value = map[i][j - 1];
                    }
                }

                // 상단 공기 청정기 위 방향
                else if(i < up && j == c - 1){
                    value = map[i + 1][j];
                }

                // 하단 공기 청정기 위 방향
                else if(i > down && i < r - 1 && j == 0){
                    value = map[i + 1][j];
                }

                // 왼쪽 방향
                else if((i == 0 || i == r - 1) && j < c - 1){
                    value = map[i][j + 1];
                }

                // 상단 공기 청정기 아래 방향
                else if(i > 0 && i < up && j == 0){
                    value = map[i - 1][j];
                }

                // 하단 공기 청정기 아래 방향
                else if(i > down && j == c - 1){
                    value = map[i - 1][j];
                }

                tmpMap[i][j] = value;
            }
        }
        map = tmpMap;
    }
}