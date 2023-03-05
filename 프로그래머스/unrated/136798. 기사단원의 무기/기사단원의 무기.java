import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 전체 수 약수 탐색
        for(int i = 1; i <= number ; i++){
            Set set = new HashSet<Integer>();
            int sqrt = (int) Math.sqrt(i); // 현재 수의 제곱근 구하기
            
            for(int j = 1; j <= sqrt; j++){
                // 제곱근보다 작은 수들로 나눈 나머지가 0일 때
                if(i % j == 0){
                    set.add(j); // 그 수는 약수
                    set.add(i / j); // 그 수로 현재수를 나눈 수도 약수
                }
            }
            
            int size = set.size();
            
            if(size > limit){
                answer += power;
            }else{
                answer += size;
            }
        }
        
        return answer;
    }
}