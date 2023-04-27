class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if(s.contains("-")){
            answer = -1;
        }else{
            answer = 1;
        }
                 
        s = s.replace("+","");
        s = s.replace("-","");
        
        answer *= Integer.parseInt(s);
        
        return answer;
    }
}