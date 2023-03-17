import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// [백준] 14567. 선수과목 (Prerequisite) (Java)
public class Main {

    static int n;
    static int m;
    static ArrayList<Integer>[] list;
    static int[] dp; // 최소 걸리는 학기
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        dp = new int[n + 1];
        sb = new StringBuilder();

        for(int i = 0; i < n + 1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
        }

        for(int i = 1; i <= n; i++){
            // 아직 탐색하지 않은 곳
            if(dp[i] == 0){
                solve(i, 1);
            }
        }

        for(int i = 1; i <= n; i++){
            sb.append(dp[i]).append(" ");
        }

        System.out.println(sb);
    }

    static void solve(int index, int count){
        dp[index] = count;
        // 연결점 탐색
        for(int i: list[index]){
            if(dp[i] < count + 1) {
                solve(i, count + 1);
            }
        }
    }
}