import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 1100. 하얀 칸 (Java)
public class Main {

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 8; i++){
            String str = br.readLine();
            String[] strings = str.split("");

            int j = 1;
            if(i % 2 == 0){
                j = 0;
            }

            while (j < 8){
                if(strings[j].equals("F")){
                    result++;
                }
                j += 2;
            }
        }
        System.out.println(result);
    }
}