import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = {};
        int index = 0;
        answer = new String[quiz.length];
        
        for(String str: quiz){
            StringTokenizer st = new StringTokenizer(str);
            
            int x = Integer.parseInt(st.nextToken());
            String cul = st.nextToken();
            int y = Integer.parseInt(st.nextToken());
            st.nextToken();
            int z = Integer.parseInt(st.nextToken());
            
            if(cul.equals("+")){
                if(x + y == z){
                    answer[index++] = "O";
                }else{
                    answer[index++] = "X";
                }
            }
            else if(cul.equals("-")){
                if(x - y == z){
                    answer[index++] = "O";
                }else{
                    answer[index++] = "X";
                }
            }
        }
        
        return answer;
    }
}