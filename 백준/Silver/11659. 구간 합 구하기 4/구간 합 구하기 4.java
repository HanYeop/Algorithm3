import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 11659. 구간 합 구하기 4 (Java)
public class Main {

    static int n,m;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int value = Integer.parseInt(st.nextToken());

            arr[i] = arr[i - 1] + value;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = arr[end] - arr[start - 1];
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}