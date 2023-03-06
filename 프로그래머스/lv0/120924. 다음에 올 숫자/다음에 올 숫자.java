class Solution {
    
    static int len;
    
    public int solution(int[] common) {
        int answer = 0;
        len = common.length;
        
        // 등차수열
        if((common[1] - common[0]) == (common[2] - common[1])){
            answer = plus(common);
        }else{
            answer = multi(common);
        }
           
        return answer;
    }

    static int plus(int[] common){
        int value = common[len - 1] - common[len - 2];
        return common[len - 1] + value;
    }
    
    static int multi(int[] common){
        int value = common[len - 1] / common[len - 2];
        return common[len - 1] * value;
    }
}