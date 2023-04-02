import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// [백준] 1107. 리모컨 (Java)
public class Main {

    static int n;
    static int m;
    static Set<Integer> set;
    static int result;
    static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        set = new HashSet<>();
        result = Math.abs(100 - n); // 시작점이 100, 시작점에서 얼마나 떨어져있는지

        if(m > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < m; i++){
                set.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i < MAX; i++){
            int len = possible(i); // 누를 수 있는지 체크 (길이)
            if(len > 0){
                int press = Math.abs(i - n);
                // 현재 채널에서 위 또는 아래 버튼 클릭 하는 경우가 더 짧은 경로면
                if (result > len + press) {
                    result = len + press;
                }
            }
        }

        System.out.println(result);
    }

    // 채널 ch를 누를 수 있는지 여부를 반환하는 함수
    static int possible(int ch) {
        if (ch == 0) {
            if (set.contains(ch)) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0; // 숫자 길이

        // 1의 자리부터 키워가면서 탐색
        while (ch > 0) {
            if (set.contains(ch % 10)) {
                return 0;
            }
            len += 1;
            ch /= 10;
        }
        return len;
    }
}