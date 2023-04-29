class Solution {
    public long solution(int n) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while(n >= 3){
            sb.append(n % 3);
            n /= 3;
        }
        sb.append(n);  
        
        answer = Long.parseLong(sb.toString(),3);
//         int mup = 1;
//         for(int i = 0; i < sb.length(); i++){
//             int cur = sb.charAt(i) - '0';
//             answer += cur * mup; 
            
//             mup *= 3;
//         }
            
        return answer;
    }
}