class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        answer = new int[2];
        int zero = 0;
        
        for(int i: lottos){
            if(i == 0){
                zero++;
            }
            
            for(int j: win_nums){
                if(i == j){
                    answer[1]++;
                }
            }
        }
        
        answer[0] = answer[1] + zero;
        
        answer[0] = solve(answer[0]);
        answer[1] = solve(answer[1]);
        
        return answer;
    }
    
    static int solve(int i){
        if(i == 0){
            return 6;
        }
        return 7 - i;
    }
}