import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

// [백준] 15685. 드래곤 커브 (Java)
public class Main {

    static int n;
    static ArrayList<Integer>[] dragon; // 0(->) 기준 드래곤 커브
    static int dragonSize = 11; // 최대 11개 세대 존재
    static boolean[][] map;
    static int result;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dragon = new ArrayList[dragonSize];
        map = new boolean[101][101];

        for(int i = 0; i < dragonSize; i++){
            dragon[i] = new ArrayList<>();
        }

        makeDragon();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());

            map[x][y] = true;
            for (int num: dragon[gen]){
                int nextIndex = (num + dir) % 4;

                x += dx[nextIndex];
                y += dy[nextIndex];
                map[x][y] = true;
            }
        }

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]){
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static void makeDragon(){
        dragon[0].add(0);

        for(int i = 1; i < dragonSize; i++){

            Stack<Integer> stack = new Stack<>();
            // 이전 세대 정보 전달
            for(int num: dragon[i - 1]){
                dragon[i].add(num);
                stack.push((num + 1) % 4);
            }

            // 이전 세대 방향 +1 값 역순 전달
            while (!stack.isEmpty()){
                dragon[i].add(stack.pop());
            }
        }
    }
}