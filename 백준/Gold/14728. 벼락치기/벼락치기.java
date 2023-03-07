import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 14728. 벼락치기 (Java)
public class Main {

    static int n,t;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][2];
        dp = new int[n + 1][t + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            arr[i][0] = time;
            arr[i][1] = score;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= t; j++){
                if(j - arr[i][0] < 0){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    int one = dp[i - 1][j]; // 새로 넣지 않는 경우
                    int two = dp[i - 1][j - arr[i][0]] + arr[i][1]; // 기존의 것에서 현재 시간만큼 빼고 넣는 경우
                    dp[i][j] = Math.max(one, two);
                }
            }
        }
        System.out.println(dp[n][t]);
    }
}