import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [백준] 2512. 예산 (Java)
public class Main {

    static int n;
    static int[] arr;
    static long money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        money = Long.parseLong(br.readLine());

        int lo = 0;
        int hi = Arrays.stream(arr).max().getAsInt();

        while (lo <= hi){
            long sum = 0;
            int mid = (lo + hi) >> 1;

            for (int i: arr){
                sum += Math.min(mid, i);

                if(sum > money){
                    break;
                }
            }

            if(sum > money){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        System.out.println(lo - 1);
    }
}