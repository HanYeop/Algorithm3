import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 9465. 스티커 (Java)
public class Main {

    static int t;
    static int n;
    static int[][] arr;
    static int[][] dp;
    static int result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int test = 0; test < t; test++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][2];
            dp = new int[n][2];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    arr[j][i] = value;
                }
            }

            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];

            for(int i = 1; i < n; i++){
                dp[i][0] = Math.max(arr[i][0] + dp[i - 1][1], dp[i - 1][0]);
                dp[i][1] = Math.max(arr[i][1] + dp[i - 1][0], dp[i - 1][1]);
            }

            result = Math.max(dp[n - 1][0], dp[n - 1][1]);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}