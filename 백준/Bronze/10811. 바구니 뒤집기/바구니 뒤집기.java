import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// [백준] 10811. 바구니 뒤집기 (Java)
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
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Stack<Integer> stack = new Stack<>();
            for(int j = start; j <= end; j++){
                stack.push(arr[j]);
            }

            for(int j = start; j <= end; j++){
                arr[j] = stack.pop();
            }
        }

        for(int i = 1; i <= n; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}