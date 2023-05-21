class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int index = 0;
        int count1 = 0;
        int count2 = 0;
        
        while(true){
            if(index > s.length() - 1){
                break;
            }
            
            char cur = s.charAt(index);
            count1 = 1;     
            count2 = 0;
            answer++;
            
            while(true){
                if(index >= s.length() - 1){
                    break;
                }
                
                char next = s.charAt(++index);
                if(cur == next){
                    count1++;
                }else{
                    count2++;
                }
                
                if(count1 == count2){
                    break;
                }
            }
            index++;
        }
        
        return answer;
    }
}