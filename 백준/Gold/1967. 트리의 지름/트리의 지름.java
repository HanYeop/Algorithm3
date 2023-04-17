import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// [백준] 1967. 트리의 지름 (Java)
class Node{
    int des, value;

    Node(int des, int value){
        this.des = des;
        this.value = value;
    }
}

public class Main {

    static int n;
    static ArrayList<Node>[] lists;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        lists = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            lists[one].add(new Node(two, value));
            lists[two].add(new Node(one, value));
        }

        for(int i = 1; i <= n; i++){
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;
        }

        System.out.println(result);
    }

    static void dfs(int index, int sum){
        result = Math.max(sum, result);

        for(Node node: lists[index]){
            int nextIndex = node.des;
            if(visited[nextIndex]){
                continue;
            }

            visited[nextIndex] = true;
            dfs(nextIndex, sum + node.value);
            visited[nextIndex] = false;
        }
    }
}