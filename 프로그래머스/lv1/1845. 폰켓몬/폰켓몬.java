import java.util.*;

class Solution {
    
    static Map<Integer, Integer> map;
    
    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length / 2;
        
        map = new HashMap<>();
        
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(int i: map.keySet()){
            answer++;
            
            if(answer >= size){
                break;
            }
        }
        
        return answer;
    }
}