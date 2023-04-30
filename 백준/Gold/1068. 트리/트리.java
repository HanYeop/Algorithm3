import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// [백준] 1068. 트리 (Java)
public class Main {

    static int n;
    static ArrayList<Integer>[] lists;
    static boolean[] visited; // 지워졌는지 여부
    static int start;
    static int target;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        lists = new ArrayList[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            lists[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int cur = Integer.parseInt(st.nextToken());

            // 루트 노드
            if(cur == -1){
                start = i;
            }else{
                lists[cur].add(i);
            }
        }

        target = Integer.parseInt(br.readLine());
        visited[target] = true;
        dfs(target);

        for(int i = 0; i < n; i++){
            if(visited[i]){
                continue;
            }

            if(lists[i].size() == 0){
                count++;
            }else{
                boolean check = true;
                for(int j: lists[i]){
                    if(!visited[j]){
                        check = false;
                        break;
                    }
                }

                if(check){
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int index){
        for(int i: lists[index]){
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}