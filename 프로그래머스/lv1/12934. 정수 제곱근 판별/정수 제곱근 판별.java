import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        int sqrt = (int)Math.sqrt(n);
        
        if(sqrt == 1 && n != 1){
            answer = -1;
        }
        else if(n % sqrt == 0){
            long next = (long)(sqrt + 1);
            answer = next * next;
        }else{
            answer = -1;
        }
        
        return answer;
    }
}