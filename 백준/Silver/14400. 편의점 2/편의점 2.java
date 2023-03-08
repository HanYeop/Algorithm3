import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [백준] 14400. 편의점2 (Java)
public class Main {

    static int n;
    static int[] xArr;
    static int[] yArr;
    static int xMin;
    static int yMin;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        xArr = new int[n];
        yArr = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xArr[i] = x;
            yArr[i] = y;
        }
        Arrays.sort(xArr);
        Arrays.sort(yArr);

        xMin = xArr[n / 2];
        yMin = yArr[n / 2];

        for(int i = 0; i < n; i++){
            result += Math.abs(xMin - xArr[i]) + Math.abs(yMin - yArr[i]);
        }
        System.out.println(result);
    }
}