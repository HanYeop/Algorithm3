class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        answer = new int[2];
        
        int n1 = numer1 * denom2;
        int n2 = numer2 * denom1;
        int n = n1 + n2;
        int d = denom1 * denom2;
        
        int max = Math.max(n,d);
        
        for(int i = max; i > 0; i--){
            if(n % i == 0 && d % i == 0){
                n /= i;
                d /= i;
                break;
            }
        }
        
        answer[0] = n;
        answer[1] = d;
        return answer;
    }
}