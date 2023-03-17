import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 14846. 직사각형과 쿼리 (Java)
public class Main {

    static int n;
    static int[][] arr;
    static int[][][] dp; // 1 ~ 10 개수
    static int q;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1][11];
        sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                int cur = Integer.parseInt(st.nextToken());
                arr[i][j] = cur;
                dp[i][j][cur]++;
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int z = 1; z <= 10; z++){
                    dp[i][j][z] += dp[i - 1][j][z] + dp[i][j - 1][z] - dp[i - 1][j - 1][z];
                }
            }
        }

        q = Integer.parseInt(br.readLine());

        // 쿼리 입력
        for(int i = 0; i < q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = 0;

            for(int j = 1; j <= 10; j++){
                int sum = dp[x2][y2][j] - dp[x2][y1 - 1][j] - dp[x1 - 1][y2][j] + dp[x1 - 1][y1 - 1][j];
                if(sum > 0){
                    result++;
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}