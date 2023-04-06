import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 20040. 사이클 게임 (Java)
public class Main {

    static int n,m;
    static int[] parents;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n];

        for(int i = 0; i < n; i++){
            parents[i] = i;
        }

        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(find(x) == find(y)){
                result = i;
                break;
            }
            union(x,y);
        }

        System.out.println(result);
    }

    static int find(int x){
        if(x == parents[x]){
            return x;
        }else{
            return parents[x] = find(parents[x]);
        }
    }

    static void union(int x, int y){
        int nx = find(x);
        int ny = find(y);

        if(nx != ny){
            parents[ny] = nx;
        }
    }
}