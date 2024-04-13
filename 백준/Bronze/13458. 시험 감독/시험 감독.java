import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 13458. 시험 감독 (Java)
public class Main {

	static int n; // 시험장 개수
	static int[] arr; // 응시자 수
	static int b,c; // 감독관
	static long result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		result = n; // 총감독관은 항상 존재
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		st = new StringTokenizer(br.readLine());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			int cur = arr[i] - b; // 총감독관 수 제외
			// 총 감독관으로 조건 만족
			if(cur <= 0) {
				continue;
			}
			result += (cur / c);
			
			// 딱 맞아떨어지지 않는 경우
			if(cur % c != 0) {
				result++;
			}		
		}
		
		System.out.println(result);
	}

}