import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 2056. 작업 (Java)
public class Main {

    static int n;
    static int[] times;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        times = new int[n + 1];
        dp = new int[n + 1];

        // 반대로 연결된 리스트 만들기
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 해당 작업에 걸리는 시간
            times[i] = Integer.parseInt(st.nextToken());
            dp[i] = times[i];

            // 선행 작업 개수
            int count = Integer.parseInt(st.nextToken());

            for(int j = 0; j < count; j++){
                int pre = Integer.parseInt(st.nextToken());
                dp[i] = Math.max(dp[i], dp[pre] + times[i]);
            }
        }

        // 결과 출력
        int result = Arrays.stream(dp).max().getAsInt();
        System.out.println(result);
    }
}