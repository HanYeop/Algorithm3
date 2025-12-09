

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [백준] 11728. 배열 합치기
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] nArr = new int[n];
		int[] mArr = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int nIndex = 0;
		int mIndex = 0;
		
		for(int i = 0; i < n+m; i++) {
			if(nIndex >= n) {
				sb.append(mArr[mIndex]).append(" ");
				mIndex++;
				continue;
			}
			
			if(mIndex >= m) {
				sb.append(nArr[nIndex]).append(" ");
				nIndex++;
				continue;
			}
			
			int nCur = nArr[nIndex];
			int mCur = mArr[mIndex];
			
			if(nCur < mCur) {
				sb.append(nCur).append(" ");
				nIndex++;
			}else {
				sb.append(mCur).append(" ");
				mIndex++;
			}
		}
		
		System.out.println(sb.toString());
	}
	
}
