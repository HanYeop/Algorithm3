import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [백준] 1158. 요세푸스 문제 (Java)
public class Main {

    static int n,k;
    static Queue<Integer> queue;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        queue = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }

        sb.append("<");

        int count = 0;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            count++;

            if(count == k){
                count = 0;
                sb.append(cur);

                if(!queue.isEmpty()){
                    sb.append(", ");
                }

            }else {
                queue.offer(cur);
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}