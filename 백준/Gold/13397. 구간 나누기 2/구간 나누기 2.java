import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [백준] 13397. 구간 나누기 2 (Java)
public class Main {

    static int n,m;
    static int[] arr; // 누적합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lo = 0;
        int hi = Arrays.stream(arr).max().getAsInt();

        while (lo < hi){
            int mid = (lo + hi) >> 1;

            int count = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);

                if(max - min > mid){
                    count++;
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                    i--;
                }
            }

            if(count < m){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }
}