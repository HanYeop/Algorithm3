import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 6603. 로또 (Java)
public class Main {

    static int k;
    static int[] s;
    static int[] result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            // 마지막 입력
            if(k == 0){
                System.out.println(sb);
                return;
            }

            s = new int[k];
            result = new int[6];
            for(int i = 0; i < k; i++){
                s[i] = Integer.parseInt(st.nextToken());
            }

            combi(0, 0);
            sb.append("\n");
        }
    }

    static void combi(int start, int count){
        if(count == 6){
            for(int i: result){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < s.length; i++){
            result[count] = s[i];
            combi(i + 1, count + 1);
        }
    }
}