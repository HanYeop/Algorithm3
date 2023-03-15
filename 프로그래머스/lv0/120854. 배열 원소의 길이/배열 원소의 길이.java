class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = {};
        int len = strlist.length;
        
        answer = new int[len];
        
        for(int i = 0; i < len; i++){
            String cur = strlist[i];
            answer[i] = cur.length();
        }
        
        return answer;
    }
}