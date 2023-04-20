import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 5585. 거스름돈 (Java)
public class Main {

    static int money;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        money = 1000 - Integer.parseInt(br.readLine());

        result += money / 500;
        money %= 500;
        result += money / 100;
        money %= 100;
        result += money / 50;
        money %= 50;
        result += money / 10;
        money %= 10;
        result += money / 5;
        money %= 5;
        result += money;

        System.out.println(result);
    }
}