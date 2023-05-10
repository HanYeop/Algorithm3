import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 11725. 트리의 부모 찾기 (Java)
public class Main {

    static ArrayList<Integer>[] lists;
    static int[] visited;
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new int[n + 1];
        lists = new ArrayList[n + 1];
        sb = new StringBuilder();
        for (int i = 0; i <= n; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            lists[one].add(two);
            lists[two].add(one);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while (!q.isEmpty()){
            int cur = q.poll();

            for(int i: lists[cur]){
                if(visited[i] != 0){
                    continue;
                }

                visited[i] = cur;
                q.offer(i);
            }
        }

        for(int i = 2; i <= n; i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
}