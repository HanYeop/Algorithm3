import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [백준] 14248. 점프 점프 (Java)
public class Main {

    static int n,s;
    static int[] arr;
    static int[] visited;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new int[n + 1];
        queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i < n + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        s = Integer.parseInt(br.readLine());

        queue.offer(s);
        visited[s] = 1;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            int left = cur - arr[cur]; // 현재위치 + 갈수있는 왼쪽
            int right = cur + arr[cur]; // 현재위치 + 갈수있는 오른쪽

            if(left <= n && left > 0 && visited[left] == 0){
                queue.offer(left);
                visited[left] = 1;
            }

            if(right <= n && right > 0 && visited[right] == 0){
                queue.offer(right);
                visited[right] = 1;
            }
        }

        int result = 0;
        for(int i: visited){
            result += i;
        }

        System.out.println(result);
    }
}