import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 1516. 게임 개발 (Java)
public class Main {

    static int n;
    static int[] times; // 각 건물 걸리는 시간
    static ArrayList<Integer>[] lists;
    static int[] dp;
    static int[] parentNum;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        times = new int[n + 1];
        lists = new ArrayList[n + 1];
        dp = new int[n + 1];
        parentNum = new int[n + 1];
        sb = new StringBuilder();

        for(int i = 0; i <= n; i++){
            lists[i] = new ArrayList<>();
        }

        // 그래프 만들기
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());

            while (true){
                int value = Integer.parseInt(st.nextToken());

                if(value == -1){
                    break;
                }
                lists[value].add(i);
                parentNum[i]++; // 부모 수 카운트
            }
        }

        solve();

        // 결과 출력
        for(int i = 1; i <= n; i++){
            sb.append(dp[i]).append("\n");
        }
        
        System.out.println(sb);
    }

    // 위상 정렬
    static void solve(){
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            // 바로 지을 수 있는 건물들 큐에 삽입 (부모 0)
            if(parentNum[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int cur = queue.poll();
            dp[cur] += times[cur]; // 현재 건물 짓기
            
            for(int i: lists[cur]){
                parentNum[i]--; // 연결된 건물들의 부모 -1

                // 바로 지을 수 있는 건물들 큐에 삽입 (부모 0)
                if(parentNum[i] == 0){
                    queue.offer(i);
                }

                // 선행건물 중 가장 오래 걸리는 건물 넣음
                dp[i] = Math.max(dp[i], dp[cur]);
            }
        }
    }
}