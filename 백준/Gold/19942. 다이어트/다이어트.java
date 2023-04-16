import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// [백준] 19942. 다이어트 (Java)
class Node{
    int p,f,s,v,price;

    Node(int p, int f, int s, int v, int price){
        this.p = p;
        this.f = f;
        this.s = s;
        this.v = v;
        this.price = price;
    }
}

public class Main {

    static int n;
    static int mp,mf,ms,mv;
    static int result = Integer.MAX_VALUE;
    static StringBuilder sb;
    static Stack<Integer> stack;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        stack = new Stack<>();
        nodes = new Node[n + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(p,f,s,v,price);
        }

        for(int i = 1; i <= n; i++){
            stack.add(i);
            dfs(i, 0, 0, 0, 0, 0);
            stack.pop();
        }

        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(result);
            System.out.println(sb);
        }
    }

    static void dfs(int index, int p, int f, int s, int v, int price){
        Node cur = nodes[index];
        price += cur.price;

        // 최소 비용보다 크면 더 이상 탐색할 필요가 없음
        if(price >= result){
            return;
        }

        p += cur.p;
        f += cur.f;
        s += cur.s;
        v += cur.v;

        if(p >= mp && f >= mf && s >= ms && v >= mv){
            result = price;
            sb = new StringBuilder();
            for(int i: stack){
                sb.append(i).append(" ");
            }
            return;
        }


        for(int i = index + 1; i <= n; i++){
            stack.add(i);
            dfs(i, p, f, s, v, price);
            stack.pop();
        }
    }
}