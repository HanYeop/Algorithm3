class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int len = arr.length;
        
        if(len == 1){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            int index = -1;
            int min = Integer.MAX_VALUE;
            
            for(int i = 0; i < len; i++){
                if(arr[i] < min){
                    min = arr[i];
                    index = i;
                }    
            }
            
            int[] tmp = new int[len - 1];
            int count = 0;
            for(int i = 0; i < len; i++){
                if(i == index){
                    continue;
                }   
                tmp[count++] = arr[i];
            }
            
            answer = tmp;
        }
        return answer;
    }
}