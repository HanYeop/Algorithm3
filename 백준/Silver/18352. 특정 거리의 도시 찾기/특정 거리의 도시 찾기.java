import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 18352. 특정 거리의 도시 찾기 (Java)
public class Main {

    static int n,m,k,x;
    static ArrayList<Integer>[] lists;
    static int[] dist;
    static StringBuilder sb;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        lists = new ArrayList[n + 1];
        dist = new int[n + 1];
        sb = new StringBuilder();
        result = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());

            lists[start].add(des);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        dist[x] = 300001;

        for(int i = 1; i <= k; i++){
            int size = q.size();
            if(size == 0){
                break;
            }

            for(int j = 0; j < size; j++){
                int cur = q.poll();

                for(int des: lists[cur]){
                    if(dist[des] == 0){

                        if(i == k){
                            result.add(des);
                        }else {
                            q.offer(des);
                        }
                        dist[des] = i;
                    }
                }
            }
        }

        Collections.sort(result);

        if(result.size() == 0){
            System.out.println("-1");
        }else {
            for(int i: result){
                sb.append(i).append('\n');
            }
            System.out.println(sb);
        }
    }
}