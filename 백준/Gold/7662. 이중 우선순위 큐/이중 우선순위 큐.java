import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// [백준] 7662. 이중 우선순위 큐 (Java)
public class Main {

    static int t;
    static int k;
    static TreeMap<Integer, Integer> map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int test = 0; test < t; test++){
            k = Integer.parseInt(br.readLine());
            map = new TreeMap<>();

            for(int i = 0; i < k; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                String type = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                // 추가
                if(type.equals("I")){
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                // 삭제
                else if(type.equals("D")){
                    // 최댓값
                    if(num == 1){
                        Map.Entry<Integer, Integer> cur = map.lastEntry();
                        if(cur == null){
                            continue;
                        }
                        // 하나밖에 없다면 삭제
                        if(cur.getValue() == 1){
                            map.pollLastEntry();
                        }
                        // 아니라면 개수를 줄임
                        else{
                            map.put(cur.getKey(), cur.getValue() - 1);
                        }
                    }
                    // 최솟값
                    else if(num == -1){
                        Map.Entry<Integer, Integer> cur = map.firstEntry();
                        if(cur == null){
                            continue;
                        }
                        // 하나밖에 없다면 삭제
                        if(cur.getValue() == 1){
                            map.pollFirstEntry();
                        }
                        // 아니라면 개수를 줄임
                        else{
                            map.put(cur.getKey(), cur.getValue() - 1);
                        }
                    }
                }
            }

            if(map.isEmpty()){
                sb.append("EMPTY");
            }else{
                sb.append(map.lastKey()).append(" ").append(map.firstKey());
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}