import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i: arr){
            if(i % divisor == 0){
                list.add(i);
            }
        }
        
        Collections.sort(list);
        int size = list.size();
        if(size == 0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[size];
            for(int i = 0; i < answer.length; i++){
                answer[i] = list.get(i);
            }
        }
        
        return answer;
    }
}