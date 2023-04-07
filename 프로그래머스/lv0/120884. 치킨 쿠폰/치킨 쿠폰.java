class Solution {
    public int solution(int chicken) {
        int answer = 0;
        
        while(chicken >= 10){
            int value = chicken / 10;
            answer += value;
            
            chicken = chicken % 10 + value;
        }
        
        return answer;
    }
}