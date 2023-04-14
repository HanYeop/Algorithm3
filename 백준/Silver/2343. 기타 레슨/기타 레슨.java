import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 2343. 기타 레슨 (Java)
public class Main {

    static int n,m;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        long lo = map[n - 1];
        long hi = 10000L * 100000;

        while (lo <= hi){
            long mid = (lo + hi) / 2;
            int count = 1;
            int sum = 0;

            for(int i = 0; i < n; i++){
                sum += map[i];
                if(sum > mid){
                    sum = 0;
                    count++;
                    i--;
                }
                if(count > m){
                    break;
                }
            }

            // 블루레이 크기를 늘려야한다.
            if(count > m){
                lo = mid + 1;
            }
            // 더 줄여본다.
            else{
                hi = mid - 1;
            }
        }

        System.out.println(hi + 1);
    }
}