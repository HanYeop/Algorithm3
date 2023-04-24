import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 20055. 컨베이어 벨트 위의 로봇 (Java)
public class Main {

    static int n,k;
    static int[][] arr;
    static int result = 1;
    static int count;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        size = n * 2 + 1;
        arr = new int[size][2];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < size; i++){
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            int[][] tmp = new int[size][2];
            for (int i = 2; i < size; i++) {
                tmp[i][0] = arr[i - 1][0];

                // 로봇 내림
                if (i >= n) {
                    tmp[i][1] = 0;
                } else {
                    tmp[i][1] = arr[i - 1][1];
                }
            }
            tmp[1][0] = arr[size - 1][0];
            arr = tmp;

            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            for (int i = n; i > 1; i--) {
                // 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상이면 전칸의 로봇 이동
                if (arr[i][1] == 0 && arr[i][0] >= 1 && arr[i - 1][1] == 1) {
                    arr[i][1] = 1;
                    arr[i - 1][1] = 0;
                    arr[i][0]--;

                    // 내구도 0된 칸 카운트
                    if (arr[i][0] == 0) {
                        k--;
                    }
                }
            }

            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if(arr[1][0] > 0){
                arr[1][1] = 1;
                arr[1][0]--;

                // 내구도 0된 칸 카운트
                if (arr[1][0] == 0) {
                    k--;
                }
            }

            if(k <= 0){
                break;
            }
            result++;
        }

        System.out.println(result);
    }
}