import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 11501. 주식 (Java)
public class Main {

    static int t;
    static int n;
    static int[] arr;
    static int max;
    static long sum;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int test = 0; test < t; test++){
            n = Integer.parseInt(br.readLine());
            sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            max = arr[n - 1];

            for(int i = n - 2; i >= 0; i--){
                if(arr[i] > max){
                    max = arr[i];
                }else{
                    sum += (max - arr[i]);
                }
            }

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}