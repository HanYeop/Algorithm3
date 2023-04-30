import java.util.*;

class Node implements Comparable<Node>{
    int index;
    float per;
    
    Node(int index, float per){
        this.index = index;
        this.per = per;
    }
    
    @Override
    public int compareTo(Node o){
        if(o.per > this.per){
            return 1; 
        }
        else if(o.per == this.per){
            return this.index - o.index;
        }
        else{
            return -1;
        }
    }
}
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        answer = new int[N];
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i: stages){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int tmp = stages.length;
        for(int i = 1; i <= N; i++){
            if(map.get(i) == null){
                pq.offer(new Node(i, 0));
            }else{
                int value = map.get(i);

                pq.offer(new Node(i, (float)value / tmp));
                tmp -= value;
            }
        }
        
        int index = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            answer[index++] = cur.index;
        }
        
        return answer;
    }
}