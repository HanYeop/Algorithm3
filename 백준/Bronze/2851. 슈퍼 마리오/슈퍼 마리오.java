import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 2851. 슈퍼 마리오 (Java)
public class Main {

    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 10; i++){
            int value = Integer.parseInt(br.readLine());
            result += value;

            if(result >= 100){
                if(result - 100 > 100 - (result - value)){
                    result -= value;
                }
                break;
            }
        }

        System.out.println(result);
    }
}