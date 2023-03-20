class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        int one = dot[0];
        int two = dot[1];
        
        if(one > 0){
            if(two > 0){
                answer = 1;
            }else{
                answer = 4;
            }
        }else{
            if(two > 0){
                answer = 2;
            }else{
                answer = 3;
            }
        }
        
        return answer;
    }
}