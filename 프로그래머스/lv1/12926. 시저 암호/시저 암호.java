class Solution {
    public String solution(String s, int n) {
        String answer = "";
        String[] strings = s.split("");
        StringBuilder sb = new StringBuilder();
        int minA = 'A';
        int maxA = 'Z';
        int minB = 'a';
        int maxB = 'z';
        
        for(String str: strings){
            if(!str.equals(" ")){
                int cur = str.charAt(0) + n; 
                // 대문자
                if(str.charAt(0) <= maxA){
                    if(cur > maxA){
                        cur = minA + (cur % maxA) - 1;
                    }
                }
                // 소문자
                else{
                    if(cur > maxB){
                        cur = minB + (cur % maxB) - 1;
                    }
                }
                sb.append((char)cur);       
            }else{
                sb.append(str);
            }
        }
        
        answer = sb.toString();
        return answer;
    }
}