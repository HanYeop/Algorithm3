import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// [백준] 11724. 연결 요소의 개수 (Java)
public class Main {

    static int n,m;
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i < n + 1; i++){
            map[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start].add(end);
            map[end].add(start);
        }

        for(int i = 1; i <= n; i++){
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            solve(i);
            result++;
        }

        System.out.println(result);
    }

    static void solve(int start){

        for(int i: map[start]){
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            solve(i);
        }
    }
}