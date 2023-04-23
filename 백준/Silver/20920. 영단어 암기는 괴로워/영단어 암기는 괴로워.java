import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// [백준] 20920. 영단어 암기는 괴로워 (Java)
class Node implements Comparable<Node>{
    String str;
    int count, len;

    Node(String str, int count){
        this.str = str;
        this.count = count;
        this.len = str.length();
    }

    @Override
    public int compareTo(Node o) {
        // 자주 나오는 단어일수록 앞에 배치
        if(this.count != o.count){
            return o.count - this.count;
        }

        // 해당 단어의 길이가 길수록 앞으로 배치
        if(this.len != o.len){
            return o.len - this.len;
        }

        // 알파벳 사전순
        return this.str.compareTo(o.str);
    }
}

public class Main {

    static int n,m;
    static HashMap<String, Integer> map;
    static PriorityQueue<Node> pq;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        pq = new PriorityQueue<>();
        sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            String cur = br.readLine();

            if(cur.length() < m){
                continue;
            }

            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }

        while (!pq.isEmpty()){
            sb.append(pq.poll().str).append("\n");
        }

        System.out.println(sb);
    }
}