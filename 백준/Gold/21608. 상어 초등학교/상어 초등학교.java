import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 21608. 상어 초등학교 (Java)
class Node implements Comparable<Node>{
    int x,y,like,blank;

    Node(int x, int y, int like, int blank){
        this.x = x;
        this.y = y;
        this.like = like;
        this.blank = blank;
    }

    @Override
    public int compareTo(Node o) {
        // 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
        if (o.like != this.like){
            return o.like - this.like;
        }

        // 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
        if (o.blank != this.blank){
            return o.blank - this.blank;
        }

        // 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로
        if(this.x != o.x){
            return this.x - o.x;
        }

        // 4. 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
        return this.y - o.y;
    }
}

public class Main {

    static int n; // 교실 크기
    static int stuNum; // 학생 수
    static int[][] classArr; // 교실 배치도
    static Queue<Integer> students; // 학생 배치 순서
    static HashSet<Integer>[] likeStudents; // 좋아하는 학생
    static int result = 0;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        stuNum = n * n;
        classArr = new int[n][n];
        likeStudents = new HashSet[stuNum + 1];
        students = new LinkedList<>();

        for(int i = 1; i <= stuNum; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int curStudent = Integer.parseInt(st.nextToken());
            likeStudents[curStudent] = new HashSet<>();
            students.offer(curStudent);

            for (int j = 0; j < 4; j++) {
                likeStudents[curStudent].add(Integer.parseInt(st.nextToken()));
            }
        }

        while (!students.isEmpty()){
            solve(students.poll());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int cur = classArr[i][j];
                int like = 0;
                for(int q = 0; q < 4; q++){
                    int nx = i + dx[q];
                    int ny = j + dy[q];

                    // 범위 벗어남
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                        continue;
                    }

                    // 선호하는 학생이 인접해 있는 경우
                    if(likeStudents[cur].contains(classArr[nx][ny])){
                        like++;
                    }
                }

                result += Math.pow(10, like - 1);
            }
        }

        System.out.println(result);
    }

    static void solve(int cur){
        TreeSet<Node> check = new TreeSet<>(); // 전체 자리 정보

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // 이미 정해진 자리
                if(classArr[i][j] != 0){
                    continue;
                }

                int blank = 0;
                int like = 0;

                for(int q = 0; q < 4; q++){
                    int nx = i + dx[q];
                    int ny = j + dy[q];

                    // 범위 벗어남
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                        continue;
                    }

                    // 인접 자리가 비어있는 자리인 경우
                    if(classArr[nx][ny] == 0){
                        blank++;
                        continue;
                    }

                    // 선호하는 학생이 인접해 있는 경우
                    if(likeStudents[cur].contains(classArr[nx][ny])){
                        like++;
                    }
                }

                check.add(new Node(i, j, like, blank));
            }
        }

        Node curPosition = check.first();
        classArr[curPosition.x][curPosition.y] = cur;
    }
}