import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 5014. 스타트링크 (Java)
public class Main {

    static int f; // 층 개수
    static int g; // 스타트링크 위치
    static int s; // 현재 위치
    static int u; // 위로 u층 가는 버튼
    static int d; // 아래로 d층 가는 버튼
    static boolean[] visited;
    static int result;
    static String NO_MOVE = "use the stairs";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        visited = new boolean[f + 1];

        if(s == g){
            System.out.println(0);
            return;
        }
        
        solve();

        if(result == 0){
            System.out.println(NO_MOVE);
        }else{
            System.out.println(result);
        }
    }

    static void solve(){
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);

        int level = 0;
        while (!q.isEmpty()){
            int size = q.size();

            // 현재 레벨만큼 반복
            for(int i = 0; i < size; i++) {
                int cur = q.poll();

                // 원하는 층 종료
                if (cur == g) {
                    result = level;
                    return;
                }

                int up = cur + u;
                int down = cur - d;

                // 위로 이동할 수 있는지
                if (up <= f && !visited[up]) {
                    q.offer(up);
                    visited[up] = true;
                }

                // 아래로 이동할 수 있는지
                if (down >= 1 && !visited[down]) {
                    q.offer(down);
                    visited[down] = true;
                }
            }

            level++;
        }
    }
}