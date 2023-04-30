import java.util.*;

class newString implements Comparable<newString>{
    String str;
    char base;
    
    newString(String str, int n){
        this.str = str;
        this.base = str.charAt(n);
    } 
    
    @Override
    public int compareTo(newString o){
        if(this.base != o.base){
            return this.base - o.base;
        }
        return this.str.compareTo(o.str);
    }
}

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        answer = new String[strings.length];
        PriorityQueue<newString> pq = new PriorityQueue<>(); 
        
        for(String s: strings){
            pq.offer(new newString(s,n));
        }
        
        int index = 0;
        while(!pq.isEmpty()){
            newString cur = pq.poll();
            answer[index++] = cur.str;
        }
        
        return answer;
    }
}