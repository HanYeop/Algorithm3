import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 17609. 회문 (Java)
public class Main {

    static int t;
    static StringBuilder result;
    static int resultState = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        result = new StringBuilder();

        for(int test = 0; test < t; test++){
            String str = br.readLine();
            resultState = Integer.MAX_VALUE;

            solve(str, 0, str.length() - 1, 0);
            result.append(resultState).append("\n");
        }

        System.out.println(result);
    }

    static void solve(String str, int start, int end, int state){
        while (start < end){
            // 회문이 아닌 경우
            if(str.charAt(start) != str.charAt(end)){
                // 이미 지웠는데도 회문이 아닌 경우
                if (state == 1){
                    state = 2;
                    break;
                }

                // 양방향 전부 지울 수 있는 경우
                if(str.charAt(start) == str.charAt(end - 1)
                        && str.charAt(start + 1) == str.charAt(end)){
                    solve(str, start, end - 1, 1);
                    solve(str, start + 1, end, 1);
                }

                // 오른쪽 기준으로 지우기
                if(str.charAt(start) == str.charAt(end - 1)){
                    end--;
                }
                // 왼쪽 기준으로 지우기
                else if(str.charAt(start + 1) == str.charAt(end)){
                    start++;
                }
                // 두 경우 전부 회문 아닌 경우
                else{
                    state = 2;
                    break;
                }

                state = 1;
                continue;
            }

            start++;
            end--;
        }
        resultState = Math.min(resultState, state);
    }
}