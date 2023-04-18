import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 1005. ACM Craft (Java)
public class Main {

    static int t;
    static int n, k;
    static int w;
    static int[] times;
    static int[] sumTimes; // 누적 시간
    static int[] parents;
    static int result;
    static ArrayList<Integer>[] lists;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int test = 0; test < t; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            times = new int[n + 1];
            sumTimes = new int[n + 1];
            parents = new int[n + 1];
            lists = new ArrayList[n + 1];
            result = 0;

            // 초기화
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                times[i] = Integer.parseInt(st.nextToken());
                lists[i] = new ArrayList<>();
            }

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                parents[child]++;
                lists[parent].add(child);
            }

            w = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            for(int i = 1; i <= n; i++){
                // 즉시 수행 가능
                if(parents[i] == 0){
                    q.offer(i);
                    sumTimes[i] = times[i];
                }
            }

            while (!q.isEmpty()){
                int cur = q.poll();

                if(cur == w){
                    sb.append(sumTimes[cur]).append("\n");
                    break;
                }

                for(int i: lists[cur]){
                    int parent = parents[i];
                    if(parent <= 0){
                        continue;
                    }
                    parents[i]--;
                    sumTimes[i] = Math.max(sumTimes[i], sumTimes[cur] + times[i]);

                    // 선행조건 전부 완료
                    if(parent == 1) {
                        q.offer(i);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}