import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// [백준] 10159. 저울 (Java)
class Node{
    int next;
    boolean plus; // next 보다 크면 true

    Node(int next, boolean plus){
        this.next = next;
        this.plus = plus;
    }
}

public class Main {

    static int n, m;
    static ArrayList<Node>[] lists;
    static boolean[] visited;
    static StringBuilder sb;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        lists = new ArrayList[n + 1];
        sb = new StringBuilder();

        for(int i = 0; i <= n; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());

            // 크고 작은 방향 입력
            lists[start].add(new Node(des, true));
            lists[des].add(new Node(start, false));
        }

        for(int i = 1; i <= n; i++){
            visited = new boolean[n + 1];
            size = n - 1; // 자신 제외

            for(Node node: lists[i]){
                int cur = node.next;

                if(visited[cur]){
                   continue;
                }

                visited[cur] = true;
                size--;

                // 시작 크기 방향 정해놓고 탐색
                solve(cur, node.plus);
            }

            sb.append(size).append("\n");
        }

        System.out.println(sb);
    }

    static void solve(int index, boolean plus){
        for(Node node: lists[index]){
            int cur = node.next;
            boolean curPlus = node.plus;

            // 이미 방문
            if(visited[cur]){
                continue;
            }

            // 방향이 바뀌면 대소비교 불가능
            if(curPlus != plus){
                continue;
            }

            visited[cur] = true;
            size--;
            solve(cur, plus);
        }
    }
}