class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a){
            int count = n / a;
            n = (count * b) + (n % a);
            
            answer += (count * b);
        }
        return answer;
    }
}