class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        
        if(len != 4 && len != 6){
            answer = false;
        }
        
        try{
            int a = Integer.parseInt(s);
        }catch(Exception e){
            answer = false;
        }
        
        return answer;
    }
}