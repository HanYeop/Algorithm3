import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// [백준] 2217. 로프 (Java)
public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long max = 0;

        for(int i = n - 1; i >= 0; i--) {
            arr[i] = arr[i] * (n - i);
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        System.out.println(max);
    }
}