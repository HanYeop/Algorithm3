import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < name.length; i++){
            String str = name[i];
            int value = yearning[i];
            
            map.put(str, value);
        }
        
        for(int i = 0; i < photo.length; i++){
            int sum = 0;
            for(String str: photo[i]){
                sum += map.getOrDefault(str, 0);
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}