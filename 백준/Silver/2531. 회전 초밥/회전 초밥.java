import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// [백준] 2531. 회전 초밥 (Java)
public class Main {

    // 회전 초밥 음식점의 벨트 상태, 메뉴에 있는 초밥의 가짓수, 연속해서 먹는 접시의 개수, 쿠폰 번호
    static int n, d, k, c;
    static int[] arr;
    static int result;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new HashMap<>();

        arr = new int[n + k];

        // 입력
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 회전 고려
        for(int i = n; i < n + k; i++){
            arr[i] = arr[i - n];
        }

        // 쿠폰 지급
        map.put(c, 1);
        for(int i = 0; i < k; i++){
//            int cur = arr[i];
//            map.put(cur, map.getOrDefault(cur, 0) + 1);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int i = k; i < n + k; i++){
            result = Math.max(result, map.size());

            int before = i - k;
            if(map.get(arr[before]) == 1){
                map.remove(arr[before]);
            }else{
                map.put(arr[before], map.get(arr[before]) - 1);
            }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(result);
    }
}