import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 1300. K번째 수 (Java)
public class Main {

    static int n; // 배열의 크기
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        // lo <= x <= hi
        long lo = 1;
        long hi = k;

        while(lo < hi) {
            long mid = (lo + hi) / 2;
            long count = 0;

            for(int i = 1; i <= n; i++) {
                // 열 개수 초과하지 않도록
                count += Math.min(mid / i, n);
            }

            if(k <= count) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }
}