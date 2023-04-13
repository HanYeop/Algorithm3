import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// [백준] 1766. 문제집 (Java)
public class Main {

    static int n, m;
    static int[] parent;
    static ArrayList<Integer>[] lists;
    static PriorityQueue<Integer> queue;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        lists = new ArrayList[n + 1];
        queue = new PriorityQueue<>();
        sb = new StringBuilder();

        for(int i = 0; i <= n; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            lists[one].add(two);
            parent[two]++;
        }

        for(int i = 1; i <= n; i++){
            // 가장 먼저 풀 수 있는 문제
            if(parent[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for(int i: lists[cur]){
                // 이미 푼 문제
                if(parent[i] == 0){
                    continue;
                }

                parent[i]--;
                // 방금 선행 조건을 전부 완성한 경우
                if(parent[i] == 0){
                    queue.offer(i);
                }
            }
        }

        System.out.println(sb);
    }
}