import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [백준] 1461. 도서관 (Java)
public class Main {

    static int n,m;
    static int[] books;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        books = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            books[i] = Integer.parseInt(st.nextToken());
        }
        books[n] = 0;

        Arrays.sort(books);

        // 중간 지점 구하기 (양수 음수 변환지점)
        int pivot = 0;
        for(int i = 0; i <= n; i++){
            if(books[i] == 0){
                pivot = i;
                break;
            }
        }

        for(int i = 0; i < pivot; i += m){
            result += Math.abs(books[i]) * 2;
        }

        for(int i = n; i > pivot; i -= m){
            result += books[i] * 2;
        }

        // 제일 큰 곳 마지막에 방문
        result -= Math.max(Math.abs(books[0]), Math.abs(books[n]));

        System.out.println(result);
    }
}