import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 10813. 공 바꾸기 (Java)
public class Main {

    static int n, m;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            arr[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            int tmp = arr[one];
            arr[one] = arr[two];
            arr[two] = tmp;
        }

        for(int i = 1; i <= n; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}