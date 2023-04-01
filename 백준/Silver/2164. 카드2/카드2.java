import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// [백준] 2164. 카드2 (Java)
public class Main {

    static int n;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            q.offer(i);
        }

        while (!q.isEmpty()){
            int delete = q.poll();

            if(q.isEmpty()){
                System.out.println(delete);
                break;
            }

            q.offer(q.poll());
        }
    }
}