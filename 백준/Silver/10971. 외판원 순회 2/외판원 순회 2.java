import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 10971. 외판원 순회 2 (Java)
public class Main {

    static int n;
    static int[][] map;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            solve(i, i, 0, 0);
        }

        System.out.println(result);
    }

    static void solve(int start, int index, int count, int sum){

        if(count == n - 1){
            if(visited[start]){
                return;
            }
            if(map[index][start] == 0){
                return;
            }

            result = Math.min(result, sum + map[index][start]);
        }

        for(int i = 0; i < n; i++){

            // 이미 방문했거나 시작점
            if(visited[i] || i == start){
                continue;
            }
            // 연결되어 있지 않다면
            if(map[index][i] == 0){
                continue;
            }

            visited[i] = true;
            solve(start, i, count + 1, sum + map[index][i]);
            visited[i] = false;
        }
    }
}