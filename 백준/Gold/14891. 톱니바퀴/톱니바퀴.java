import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [백준] 14891. 톱니바퀴 (Java)
class Pair{
    int type, dir;

    Pair(int type, int dir){
        this.type = type;
        this.dir = dir;
    }
}

public class Main {

    final static int size = 4;
    static int[][] arr;
    static boolean[] visited;
    static Queue<Pair> queue; // 회전할 톱니바퀴들
    static int k;
    static int result;
    static int score = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[size][8];
        for(int i = 0; i < size; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < 8; j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken()) - 1; // 0번부터 시작
            int dir = Integer.parseInt(st.nextToken());

            visited = new boolean[4];
            queue = new LinkedList<>();
            visited[type] = true;
            solve(type, dir);
            turn();
        }

        for(int i = 0; i < 4; i++){
            if(arr[i][0] == 1){
                result += score;
            }
            score *= 2;
        }

        System.out.println(result);
    }

    static void solve(int type, int dir){
        queue.add(new Pair(type, dir));

        // 좌측 회전 가능하다면
        if(type != 0 && !visited[type - 1] && arr[type - 1][2] != arr[type][6]){
            visited[type - 1] = true;
            solve(type - 1, dir * -1);
        }

        // 우측 회전 가능하다면
        if(type != 3 && !visited[type + 1] && arr[type][2] != arr[type + 1][6]){
            visited[type + 1] = true;
            solve(type + 1, dir * -1);
        }
    }

    static void turn(){
        while (!queue.isEmpty()){
            Pair cur = queue.poll();
            int type = cur.type;
            int dir = cur.dir;

            Queue<Integer> tmp = new LinkedList<>();
            if(dir == 1){
                tmp.add(arr[type][7]);
                for(int i = 0; i < 7; i++){
                    tmp.add(arr[type][i]);
                    arr[type][i] = tmp.poll();
                }
                arr[type][7] = tmp.poll();
            }else{
                tmp.add(arr[type][0]);
                for(int i = 7; i > 0; i--){
                    tmp.add(arr[type][i]);
                    arr[type][i] = tmp.poll();
                }
                arr[type][0] = tmp.poll();
            }
        }
    }
}