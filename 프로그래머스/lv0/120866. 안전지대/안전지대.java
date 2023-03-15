class Solution {
    
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    
    public int solution(int[][] board) {
        int answer = 0;
        int len = board[0].length;
        
        boolean[][] visited = new boolean[len][len];
        answer = len * len;
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                // 지뢰라면
                if(board[i][j] == 1){  
                    visited[i][j] = true;
                    answer--;
                    
                    for(int q = 0; q < 8; q++){
                        int nx = i + dx[q];
                        int ny = j + dy[q];
                        
                        // 범위 초과
                        if(nx < 0 || ny < 0 || nx >= len || ny >= len){
                            continue;
                        }
                        
                        // 이미 방문
                        if(visited[nx][ny]){
                           continue; 
                        }
                        
                        // 지뢰라면
                        if(board[nx][ny] == 1){
                            continue;
                        }
                        
                        visited[nx][ny] = true;
                        answer--;
                    }
                }
            }
        }
        
        return answer;
    }
}