import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 9663. N-Queen (Java)
public class Main {

    static int n;
    static int[] board;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n];

        solve(0);
        System.out.println(result);
    }

    static void solve(int index){

        // 완성된 경우
        if (index == n) {
            result++;
            return;
        }

        for(int i = 0; i < n; i++){
            board[index] = i; // [index][i]에 queen을 놓는다.

            if(check(index)){
                solve(index + 1);
            }
        }
    }

    static boolean check(int index){
        // 같은 열이면 안되고, 대각선상에 있어서도 안 된다.
        for (int i = 0; i < index; i++) {
            if (board[index] == board[i] || index - i == Math.abs(board[index] - board[i])) {
                return false;
            }
        }
        return true;
    }
}