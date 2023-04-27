class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;
        String[] strings = s.split("");
        
        for(String str: strings){
            if(str.equals("p") || str.equals("P")){
                pCount++;
            }
            if(str.equals("y") || str.equals("Y")){
                yCount++;
            }
        }
        
        if(pCount != yCount){
            answer = false;
        }

        return answer;
    }
}