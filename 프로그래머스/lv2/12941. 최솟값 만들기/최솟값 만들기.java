import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        int len = A.length;
        
        for(int i = 0; i < len; i++){
            int a = A[i];
            int b = B[len - i - 1];
            
            answer += a * b;
        }

        return answer;
    }
}