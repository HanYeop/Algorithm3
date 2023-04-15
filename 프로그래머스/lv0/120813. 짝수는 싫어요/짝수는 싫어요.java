class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int size = n / 2;
        
        if(n % 2 != 0){
            size++;
        }
        
        answer = new int[size];
        int count = -1;
        
        for(int i = 0; i < size; i++){
            answer[i] = count += 2;
        }
        return answer;
    }
}