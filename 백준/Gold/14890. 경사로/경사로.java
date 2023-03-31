import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// [백준] 14890. 경사로 (Java)
public class Main {

    static int n, l;
    static int[][] map;
    static boolean[][] visited;
    static int result;
    static ArrayList<Integer> tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            if(!row(i)){
                for(int num: tmp){
                    visited[i][num] = false;
                }
            }
        }

        for(int i = 0; i < n; i++){
            visited = new boolean[n][n];
            if(!col(i)){
                for(int num: tmp){
                    visited[num][i] = false;
                }
            }
        }

        System.out.println(result);
    }

    static boolean row(int index){

        int pre = map[index][0];
        tmp = new ArrayList<>();

        for(int i = 1; i < n; i++){
            int cur = map[index][i];

            // 높이 차이가 2 이상인 경우
            if(Math.abs(cur - pre) >= 2){
//                System.out.println("1높이차가 2이상 index: " + index + " i: " + i);
                return false;
            }

            // 오르막길
            if(pre + 1 == cur){
                // 경사로를 만들 자리가 부족할 경우
                if(i - l < 0){
//                    System.out.println("1경사로 자리 부족 index: " + index + " i: " + i);
                    return false;
                }
                for(int j = i - 1; j >= i - l; j--){
                    // 높이가 달라 만들 수 없는 경우
                    if(map[index][j] != pre){
//                        System.out.println("1높이가 다름 index: " + index + " j: " + j);
                        return false;
                    }
                    // 이미 경사로 존재
                    if(visited[index][j]){
//                        System.out.println("1이미 경사로 존재 index: " + index + " j: " + j);
                        return false;
                    }
                }
                for(int j = i - 1; j >= i - l; j--){
                    visited[index][j] = true;
                    tmp.add(j);
                }
                pre = cur;
            }
            // 내리막길
            else if(pre - 1 == cur){
                // 경사로를 만들 자리가 부족할 경우
                if(i + l > n){
//                    System.out.println("2경사로 자리 부족 index: " + index + " i: " + i);
                    return false;
                }
                for(int j = i; j < i + l; j++){
                    // 높이가 달라 만들 수 없는 경우
                    if(map[index][j] != cur){
//                        System.out.println("2높이가 다름 index: " + index + " j: " + j);
                        return false;
                    }
                    // 이미 경사로 존재
                    if(visited[index][j]){
//                        System.out.println("2이미 경사로 존재 index: " + index + " j: " + j);
                        return false;
                    }
                }
                for(int j = i; j < i + l; j++){
                    visited[index][j] = true;
                    tmp.add(j);
                }
                pre = map[index][i + l - 1];
                i = i + l - 1;
            }else{
                pre = cur;
            }
        }

        result++;
        return true;
    }

    static boolean col(int index){
        int pre = map[0][index];
        tmp = new ArrayList<>();

        for(int i = 1; i < n; i++){
            int cur = map[i][index];

            // 높이 차이가 2 이상인 경우
            if(Math.abs(cur - pre) >= 2){
//                System.out.println("3높이차가 2이상 index: " + index + " i: " + i);
                return false;
            }

            // 오르막길
            if(pre + 1 == cur){
                // 경사로를 만들 자리가 부족할 경우
                if(i - l < 0){
//                    System.out.println("3경사로 자리 부족 index: " + index + " i: " + i);
                    return false;
                }
                for(int j = i - 1; j >= i - l; j--){
                    // 높이가 달라 만들 수 없는 경우
                    if(map[j][index] != pre){
//                        System.out.println("3높이가 다름 index: " + index + " j: " + j);
                        return false;
                    }
                    // 이미 경사로 존재
                    if(visited[j][index]){
//                        System.out.println("3이미 경사로 존재 index: " + index + " j: " + j);
                        return false;
                    }
                }
                for(int j = i - 1; j >= i - l; j--){
                    visited[j][index] = true;
                    tmp.add(j);
                }
                pre = cur;
            }
            // 내리막길
            else if(pre - 1 == cur){
                // 경사로를 만들 자리가 부족할 경우
                if(i + l > n ){
//                    System.out.println("4경사로 자리 부족 index: " + index + " i: " + i);
                    return false;
                }
                for(int j = i; j < i + l; j++){
                    // 높이가 달라 만들 수 없는 경우
                    if(map[j][index] != cur){
//                        System.out.println("4높이가 다름 index: " + index + " j: " + j);
                        return false;
                    }
                    // 이미 경사로 존재
                    if(visited[j][index]){
//                        System.out.println("4이미 경사로 존재 index: " + index + " j: " + j);
                        return false;
                    }
                }
                for(int j = i; j < i + l; j++){
                    visited[j][index] = true;
                    tmp.add(j);
                }
                pre = map[i + l - 1][index];
                i = i + l - 1;
            }else{
                pre = cur;
            }
        }

        result++;
        return true;
    }
}