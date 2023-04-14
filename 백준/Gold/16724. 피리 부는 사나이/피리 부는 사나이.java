import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// [백준] 16724. 피리 부는 사나이 (Java)
public class Main {

    static int n,m;
    static int[][][] map;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m][2];
        parent = new int[n * m]; // 2차원 유니온 파인드

        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }

        for(int i = 0; i < n; i++){
            String string = br.readLine();
            for(int j = 0; j < m; j++){
                char cur = string.charAt(j);
                if(cur == 'U'){
                    map[i][j][0] = -1;
                    map[i][j][1] = 0;
                }
                else if(cur == 'D'){
                    map[i][j][0] = 1;
                    map[i][j][1] = 0;
                }
                else if(cur == 'L'){
                    map[i][j][0] = 0;
                    map[i][j][1] = -1;
                }
                else if(cur == 'R'){
                    map[i][j][0] = 0;
                    map[i][j][1] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int curIndex = i * m + j;
                int nextIndex = (i + map[i][j][0]) * m + j + map[i][j][1];

                union(curIndex, nextIndex);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < parent.length; i++){
            set.add(find(i));
        }

        System.out.println(set.size());
    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        int one = find(x);
        int two = find(y);

        parent[one] = two;
    }
}