class Solution {
    public int[] solution(int num, int total) {
        int[] answer = {};
        answer = new int[num];
        
        int left = -1000;
        int right = left + num;
        int sum = 0;
        
        for(int i = 0; i < num; i++){
            sum += left + i;
        }
        
        while(sum <= 1000){
            if(sum == total){         
                for(int i = 0; i < num; i++){
                    answer[i] = left + i;    
                }
                break;
            }
            
            sum -= left++;
            sum += right++;
        }
        
        
        return answer;
    }
}