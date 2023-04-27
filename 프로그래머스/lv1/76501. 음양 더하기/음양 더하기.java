class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 123456789;
        answer = 0;
        
        for(int i = 0; i < signs.length; i++){
            int value = absolutes[i];
            
            if(!signs[i]){
                value *= -1;
            }
            
            answer += value;
        }
        return answer;
    }
}