
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [백준] 4153. 직각삼각형
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long[] arr = new long[3];
			
			for(int i = 0; i < 3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
				break;
			}
			
			Arrays.sort(arr);
			
			if(((arr[0] * arr[0]) + (arr[1] * arr[1])) == (arr[2] * arr[2])) {
				sb.append("right");
			}else {
				sb.append("wrong");
			}
			
			sb.append("\n");
		}	
		
		System.out.println(sb);
	}
	
}
