import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 9470. Strahler 순서 (Java)
public class Main {

    static int t;
    static int k,m,p;
    static ArrayList<Integer>[] map; // 각각 강 연결 여부
    static int[] parent; // 강 부모 개수
    static ArrayList<Integer>[] dp; // 강의 Strahler 순서 값 개수
    static StringBuilder sb;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int test = 1; test <= t; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            map = new ArrayList[m + 1];
            dp = new ArrayList[m + 1];
            parent = new int[m + 1];
            result = 0;

            for(int i = 0; i <= m ; i++){
                map[i] = new ArrayList<>();
                dp[i] = new ArrayList<>();
            }

            for(int i = 0; i < p; i++){
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int des = Integer.parseInt(st.nextToken());

                map[start].add(des);
                parent[des]++;
            }

            solve();
            sb.append(k).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    static void solve(){
        Queue<Integer> q = new LinkedList<>();

        // 강의 근원 전부 큐에 삽입
        for(int i = 1; i <= m; i++){
            if(parent[i] == 0){
                q.offer(i);
                dp[i].add(1);
            }
        }

        while (!q.isEmpty()){
            int cur = q.poll();

            int max = -1;
            int value = 0;
            for(int i: dp[cur]){
                if(max < i){
                    max = i;
                    value = i;
                }else if(max == i && value == max){
                    value += 1;
                }
            }

            if(value > result){
                result = value;
            }

            for(int i: map[cur]){
                parent[i]--;
                dp[i].add(value);

                if(parent[i] == 0){
                    q.offer(i);
                }
            }
        }
    }
}