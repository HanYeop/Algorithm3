import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int sum = 0;
        int max = 0;
        
        for(int i: sides){
            if(max < i){
                max = i;
            }    
        }
        
        for(int i: sides){
            if(max >= i){
                sum += i;
            }    
        }
        
        sum -= max;
        
        if(max < sum){
            answer = 1;
        }else{
            answer = 2;
        }
        
        return answer;
    }
}