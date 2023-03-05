import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// [백준] 2015. 수들의 합 4 (Java)
public class Main {

    static int n,k;
    static long result;
    static int[] arr;
    static Map<Integer, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int value = Integer.parseInt(st.nextToken());
            arr[i] = arr[i - 1] + value; // 누적합

            // 현재 누적합
            int curSum = arr[i];

            // 현재 누적합이 k면
            if(curSum == k){
                result++;
            }
            // 현재 누적합에서 이전에 나온 수로 k 만들 수 있으면
            result += map.getOrDefault(curSum - k, 0L);

            // 누적합에서 나온 수들 개수 입력
            map.put(curSum, map.getOrDefault(curSum, 0L) + 1);
        }

        System.out.println(result);
    }
}