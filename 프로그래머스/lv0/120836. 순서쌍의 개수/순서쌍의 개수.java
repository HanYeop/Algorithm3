import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> oList = new ArrayList<>();
        ArrayList<Integer> tList = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                oList.add(i);
            }
        }
        
        answer = oList.size();
        
        return answer;
    }
}