class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] visited = new boolean[n + 1];
        
        for(int i: section){
            visited[i] = true;
        }
        
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                continue;
            }        
            for(int j = i; j < i + m; j++){
                if(j > n){
                    break;
                }
                visited[j] = false;
            }
            answer++;
        }
        
        return answer;
    }
}