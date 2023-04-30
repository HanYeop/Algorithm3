import java.util.*;

class Solution {
    static int[] div;
    static StringBuilder sb;
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = new String[n];
        boolean[][] map1 = new boolean[n][n];
        boolean[][] map2 = new boolean[n][n];
        div = new int[n];
        div[0] = (int)Math.pow(2, n - 1);
        
        for(int i = 1; i < n; i++){
            div[i] = div[i - 1] / 2;    
        }
        
        for(int i = 0; i < n; i++){
            solve(i, arr1[i], map1, n);
            solve(i, arr2[i], map2, n);
        }
        
        for(int i = 0; i < n; i++){
            sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(map1[i][j] || map2[i][j]){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString(); 
        }
        return answer;
    }
    
    static void solve(int index, int value, boolean[][] map, int n){
        for(int i = 0; i < n; i++){
            if(value >= div[i]){
                map[index][i] = true;
                value %= div[i];
            }else{
                map[index][i] = false;
            }
        }
    }
}