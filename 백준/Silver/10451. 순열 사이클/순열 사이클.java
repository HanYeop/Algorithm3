import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 10451. 순열 사이클 (Java)
public class Main {

    static int T;
    static int n;
    static int[] arr;
    static boolean[] visited;
    static int count;
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        result = new StringBuilder();

        for(int test = 0; test < T; test++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            count = 0;
            visited = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++){
                if(visited[i]){
                    continue;
                }

                visited[i] = true;
                dfs(i);
                count++;
            }

            result.append(count).append("\n");
        }

        System.out.println(result);
    }

    static void dfs(int index){
        int next = arr[index];
        if(!visited[next]){
            visited[next] = true;
            dfs(next);
        }
    }
}