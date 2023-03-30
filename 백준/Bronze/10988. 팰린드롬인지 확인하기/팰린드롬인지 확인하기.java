import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 10988. 팰린드롬인지 확인하기 (Java)
public class Main {

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append(br.readLine());

        String str1 = sb.toString();
        String str2 = sb.reverse().toString();

        if(str1.equals(str2)){
            result = 1;
        }
        System.out.println(result);
    }
}