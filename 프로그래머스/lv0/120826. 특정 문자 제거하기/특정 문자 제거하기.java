class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        String[] strings = my_string.split("");
        StringBuilder sb = new StringBuilder();
        for(String str: strings){
            if(!str.equals(letter)){
                sb.append(str);
            }
        }
        
        answer = sb.toString();
        
        return answer;
    }
}