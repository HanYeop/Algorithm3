import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// [백준] 9935. 문자열 폭발 (Java)
public class Main {

    static Stack<String> stack;
    static Stack<String> tmpStack; // 임시 저장 스택
    static String[] strings;
    static String[] target;
    static int targetLastIndex;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        stack = new Stack<>();
        strings = br.readLine().split("");
        target = br.readLine().split("");
        targetLastIndex = target.length - 1;
        sb = new StringBuilder();

        solve();

        if(sb.length() == 0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb.reverse());
        }
    }

    static void solve() {
        for (String str : strings) {
            stack.add(str);
            // 타겟 마지막 값과 현재 문자가 같은 경우
            if (str.equals(target[targetLastIndex]) && stack.size() > targetLastIndex) {
                // 폭발이 일어나지 않았다면
                if(!check()){
                    while (!tmpStack.isEmpty()){
                        stack.add(tmpStack.pop());
                    }
                }
            }
        }

        // 폭발 종료 후 결과 저장
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
    }

    // 폭발이 일어나는지 체크
    static boolean check(){
        tmpStack = new Stack<>();

        for(int i = targetLastIndex; i >= 0; i--){
            String curString = stack.pop();
            tmpStack.add(curString);

            // 같지 않은 경우 폭발이 일어나지 않음
            if(!target[i].equals(curString)){
                return false;
            }
        }

        return true;
    }
}