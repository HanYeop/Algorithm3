import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

// [백준] 1269. 대칭 차집합 (Java)
public class Main {

    static int n,m;
    static HashMap<Integer, Boolean> a,b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new HashMap<>();
        b = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a.put(Integer.parseInt(st.nextToken()), true);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            b.put(Integer.parseInt(st.nextToken()), true);
        }

        for(int i : a.keySet()){
            if(b.get(i) != null){
                m--;
            }
        }

        for(int i : b.keySet()){
            if(a.get(i) != null){
                n--;
            }
        }

        System.out.println(n + m);
    }
}