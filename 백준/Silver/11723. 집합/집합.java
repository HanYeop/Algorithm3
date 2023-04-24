import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// [백준] 11723. 집합 (Java)
public class Main {

    static int m;
    static HashSet<Integer> set;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        m = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        sb = new StringBuilder();

        for(int i = 0; i < m; i++){
            String cur = br.readLine();

            if(cur.equals("all")){
                set = new HashSet<>();
                for(int j = 1; j <= 20; j++){
                    set.add(j);
                }
            }else if(cur.equals("empty")){
                set = new HashSet<>();
            }else {
                StringTokenizer st = new StringTokenizer(cur);
                String type = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                switch (type) {
                    case "add": {
                        set.add(number);
                        break;
                    }
                    case "remove": {
                        set.remove(number);
                        break;
                    }
                    case "check": {
                        if(set.contains(number)){
                            sb.append(1);
                        }else{
                            sb.append(0);
                        }
                        sb.append("\n");
                        break;
                    }
                    case "toggle": {
                        if(set.contains(number)){
                            set.remove(number);
                        }else{
                            set.add(number);
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}