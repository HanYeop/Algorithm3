import java.util.*;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        int size = (int)Math.log10(n) + 1;
        answer = new int[size];
        
        int count = 0;
        while(n > 0){
            answer[count++] = (int)(n % 10);
            n /= 10;
        }
        return answer;
    }
}