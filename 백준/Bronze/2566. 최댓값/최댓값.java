import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max = -1;
    static int x = -1;
    static int y = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 1; i <= 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 9; j++){
                int value = Integer.parseInt(st.nextToken());

                if(value > max){
                    max = value;
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(x + " " + y);
    }
}