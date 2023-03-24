import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// [백준] 1911. 흙길 보수하기 (Java)
public class Main {

    static int n;
    static int l;
    static int tmp;
    static Map<Integer, Integer> map;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new TreeMap<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map.put(start, end);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int start = Math.max(tmp,entry.getKey());
            int des = entry.getValue();
            int value = des - start;

            if(value <= 0){
                continue;
            }

            result += (value / l);

            if(value % l != 0){
                result++;
                tmp = des + l - (value % l);
            }
        }

        System.out.println(result);
    }
}