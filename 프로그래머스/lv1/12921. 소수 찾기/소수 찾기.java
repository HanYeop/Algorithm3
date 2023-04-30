class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] prime = new boolean[n + 1];
        
        // 소수가 아님
        prime[0] = true;
        prime[1] = true;
        
        for(int i = 2; i <= n; i++){
            // 소수가 아님
            if(prime[i]){
                continue;
            }
            
            for(int j = i * 2; j <= n; j += i){
                prime[j] = true;
            }
        }
        
        for(boolean check: prime){
            if(!check){
                answer++;
            }
        }
        
        return answer;
    }
}