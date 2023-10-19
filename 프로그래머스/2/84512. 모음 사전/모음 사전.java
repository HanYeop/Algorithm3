import java.util.*;

class Solution {
    
    static int count = 0;
    static HashMap<String, Integer> map;
    
    public int solution(String word) {
        int answer = 0;
        map = new HashMap<>();
        
        solve(0, "");
        
        answer = map.get(word);
        
        return answer;
    }
    
    static void solve(int i, String str){    
        map.put(str, count++);
        //System.out.println(str + " " + count);
        if(i == 5){
            return;
        }
        
        solve(i + 1, str + "A");
        solve(i + 1, str + "E");
        solve(i + 1, str + "I");
        solve(i + 1, str + "O");
        solve(i + 1, str + "U");
    }
}