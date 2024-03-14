import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 1475. 방 번호 (Java)
public class Main {

    static String n;
    static String[] str;
    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();
        number = new int[10];

        str = n.split("");

        for(String cur: str) {
            int i = Integer.parseInt(cur);
            if (i == 6) {
                i = 9;
            }
            number[i]++;
        }

        if(number[9] % 2 == 0){
            number[9] /= 2;
        }else{
            number[9] = (number[9] / 2) + 1;
        }
        
        int max = 0;
        for(int i = 0; i < 10; i++){
            if(number[i] > max){
                max = number[i];
            }
        }

        System.out.println(max);
    }
}