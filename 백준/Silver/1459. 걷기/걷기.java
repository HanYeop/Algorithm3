import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 1459. 걷기 (Java)
public class Main {

    static long x,y,w,s;
    static long result1, result2, result3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());
        w = Long.parseLong(st.nextToken());
        s = Long.parseLong(st.nextToken());

        // 수평으로만 이동
        result1 = (x + y) * w;
        
        // 대각선으로만 이동
        if((x + y) % 2 == 0) {
            result2 = Math.max(x, y) * s;
        }else{
            result2 = (Math.max(x, y) - 1) * s + w;
        }

        // 대각선 + 수평 이동
        result3 = (Math.min(x, y)) * s + (Math.abs(x - y)) * w;

        System.out.println(Math.min(result1, Math.min(result2, result3)));
    }
}