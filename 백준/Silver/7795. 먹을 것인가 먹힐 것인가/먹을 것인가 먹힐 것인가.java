import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [백준] 7795. 먹을 것인가 먹힐 것인가 (Java)
public class Main {

    static int t;
    static int n, m;
    static int[] a,b;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int test = 0; test < t; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            a = new int[n];
            b = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(b);

            int result = 0;
            for(int i = 0; i < n; i++){
                result += find(a[i]);
            }

            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    static int find(int target){

        int lo = 0;
        int hi = m - 1;
        int mid = 0;
        int result = 0;

        // 자기보다 큰 먹이
        if(target <= b[lo]){
            return 0;
        }

        while (lo <= hi){
            mid = (lo + hi) / 2;
            int midValue = b[mid];

            if(target > midValue){
                result = mid;
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }

        return result + 1;
    }
}