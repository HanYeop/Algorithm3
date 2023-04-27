class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if(a > b){
            answer = solve(b,a);
        }else{
            answer = solve(a,b);
        }
        return answer;
    }
    
    static long solve(int x, int y){
        long sum = 0;
        for(int i = x; i <= y; i++){
            sum += i;
        }
        return sum;
    }
}