import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// [백준] 2331. 반복수열 (Java)
public class Main {

    static long a;
    static int p;
    static HashMap<Long, Integer> map;
    static int result = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        map.put(a, 1);
        long cur = a;

        while (true){
            long next = 0;

            for(int i = 1000000000; i > 0; i /= 10){
                long num = cur / i; // 현재 자리수
                next += Math.pow(num,p);
                cur %= i;
            }

            // 이미 있으면 반복 시작, 처음 나온 위치 -1이 총 개수
            if(map.containsKey(next)){
                System.out.println(map.get(next) - 1);
                return;
            }

            map.put(next, result);
            result++;
            cur = next;
        }
    }
}