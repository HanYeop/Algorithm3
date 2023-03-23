import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 2239. 스도쿠 (Java)
public class Main {

    static int[][] map;
    static ArrayList<Integer> zeroX;
    static ArrayList<Integer> zeroY;
    static int size; // 퍼즐 완성되었는지 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        zeroX = new ArrayList<>();
        zeroY = new ArrayList<>();

        for(int i = 0; i < 9; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < 9; j++) {
                int value = Integer.parseInt(str[j]);
                // 채워야 하는 퍼즐
                if(value == 0){
                    zeroX.add(i);
                    zeroY.add(j);
                }else{
                    map[i][j] = value;
                }
            }
        }

        size = zeroX.size();
        solve(0);
    }

    static void solve(int index){

        // 전부 채웠는지 확인
        if(index == size){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        // 현재 위치
        int curX = zeroX.get(index);
        int curY = zeroY.get(index);

        for(int i = 1; i <= 9; i++){
            if(boxCheck(curX, curY, i) && rowCheck(curX, curY, i) && calCheck(curX, curY, i)){
                map[curX][curY] = i;
                solve(index + 1);
                map[curX][curY] = 0;
            }
        }
    }

    static boolean boxCheck(int x, int y, int value){
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        for(int i = startX; i < 3 + startX; i++){
            for(int j = startY; j < 3 + startY; j++){
                if(i == x && y == j){
                    continue;
                }
                if(map[i][j] == value){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean rowCheck(int x, int y, int value){
        for(int i = 0; i < 9; i++){
            if(i == y){
                continue;
            }
            if(map[x][i] == value){
                return false;
            }
        }

        return true;
    }

    static boolean calCheck(int x, int y, int value){
        for(int i = 0; i < 9; i++){
            if(x == i){
                continue;
            }
            if(map[i][y] == value){
                return false;
            }
        }

        return true;
    }
}