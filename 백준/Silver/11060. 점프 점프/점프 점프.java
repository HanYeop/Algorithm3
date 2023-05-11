import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [백준] 11060. 점프 점프 (Java)
public class Main {

    static int n;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int level = 0;

        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int cur = q.poll();

                if(cur == n - 1){
                    System.out.println(level);
                    System.exit(0);
                }

                for(int j = 1; j <= arr[cur]; j++){
                    int next = cur + j;
                    if(next >= n){
                        break;
                    }
                    if(visited[next]){
                        continue;
                    }

                    visited[next] = true;
                    q.offer(next);
                }
            }
            level++;
        }

        System.out.println(-1);
    }
}