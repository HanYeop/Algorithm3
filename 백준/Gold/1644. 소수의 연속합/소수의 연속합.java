import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// [백준] 1644. 소수의 연속합 (Java)
public class Main {

    static int n;
    static boolean[] arr;
    static int result;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new boolean[n + 1];
        list = new ArrayList<>();

        prime();
        solve();
        System.out.println(result);
    }

    static void prime(){
        // 0, 1, 2는 소수가 아니다.
        arr[0] = true;
        arr[1] = true;

        for(int i = 2; i <= n; i++){
            // 소수일 때
            if(!arr[i]) {
                list.add(i);
                for (int j = i * 2; j <= n; j += i){
                    arr[j] = true;
                }
            }
        }
    }

    static void solve(){
        for(int i = 0; i < list.size(); i++){
            int sum = list.get(i);

            for(int j = i + 1; j < list.size(); j++){
                sum += list.get(j);
                if(sum >= n){
                    break;
                }
            }

            if(sum == n){
                result++;
            }
        }
    }
}