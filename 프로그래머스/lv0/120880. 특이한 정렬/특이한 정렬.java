import java.util.*;

class Node implements Comparable<Node>{
    int dis, value;
    
    Node(int dis, int value){
        this.dis = dis;
        this.value = value;
    }
    
    @Override
    public int compareTo(Node o) {
        if(o.dis == this.dis){
            return o.value - this.value;
        }else{
            return this.dis - o.dis;
        }
    }
}

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = {};
        int size = numlist.length;
        answer = new int[size];
        
        Node[] arr = new Node[size];
        for(int i = 0; i < size; i++){
            int dis = Math.abs(n - numlist[i]);
            arr[i] = new Node(dis,numlist[i]);
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i < size; i++){
            answer[i] = arr[i].value;
        }
        return answer;
    }
}