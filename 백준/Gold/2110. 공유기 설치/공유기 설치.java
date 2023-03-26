import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [백준] 2110. 공유기 설치 (Java)
public class Main {

    static int n,c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int lo = 1;
        int hi = arr[n - 1] - arr[0] + 1;

        // Upper Bound
        while (lo < hi){
            int mid = (hi + lo) / 2;

            if(solve(mid) < c){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        System.out.println(lo - 1);
    }

    static int solve(int dis){

        int count = 1; // 첫번째 집은 무조건 설치
        int last = arr[0]; // 마지막 설치 위치

        for(int i = 1; i < arr.length; i++){
            int locate = arr[i];

            // 공유기 설치 가능 (최소 거리(distance)보다 크거나 같을 때)
            if(locate - last >= dis){
                count++;
                last = locate;
            }
        }

        return count;
    }
}