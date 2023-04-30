import java.util.*;

class Solution {
    
    static int[] combi;
    static boolean[] prime;
    static int result;
    
    public int solution(int[] nums) {
        int answer = -1;
        int max = (1 + 1000) * 1000 / 2;
        
        combi = new int[3];
        prime = new boolean[max + 1];
        prime[0] = true;
        prime[1] = true;
        
        for(int i = 2; i <= max; i++){
            if(prime[i]){
                continue;
            }
            for(int j = i * 2; j <= max; j += i){
                prime[j] = true;
            }
        }
        
        for(int i = 0; i <= nums.length - 3; i++){
            combination(i, 0, nums);
        }
        
        answer = result;
        return answer;
    }
    
    static void combination(int index, int count, int[] nums){
        combi[count] = nums[index];
        
        if(count == 2){
            int sum = 0;
            for(int i: combi){
                sum += i;
            }
            
            if(!prime[sum]){
                result++;
            }
            return;
        }
        
        for(int i = index + 1; i < nums.length; i++){
            combination(i, count + 1, nums);    
        }
    }
}