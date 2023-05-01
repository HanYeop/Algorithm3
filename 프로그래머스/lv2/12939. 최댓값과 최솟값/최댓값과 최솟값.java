import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<Integer> list = new ArrayList<>();
        String[] strings = s.split(" ");
        
        for(String str: strings){
            list.add(Integer.parseInt(str));
        }
        
        Collections.sort(list);
        
        answer += String.valueOf(list.get(0)) + " " + String.valueOf(list.get(list.size() - 1));
        return answer;
    }
}