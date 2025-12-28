
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 18917. 수열과 쿼리 38
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = Integer.parseInt(br.readLine());
		long sum = 0;
		long xor = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			
			if(num == 1) {
				int x = Integer.parseInt(st.nextToken());
				sum += x;
				xor ^= x;
			}
			else if(num == 2) {
				int x = Integer.parseInt(st.nextToken());
				sum -= x;
				xor ^= x;
			}
			else if(num == 3) {
				sb.append(sum).append("\n");
			}
			else if(num == 4) {
				sb.append(xor).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
}
