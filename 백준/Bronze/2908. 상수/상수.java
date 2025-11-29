

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		String b = st.nextToken();
		
		String[] aList = a.split("");
		String[] bList = b.split("");
		
		StringBuilder sbA = new StringBuilder();
		StringBuilder sbB = new StringBuilder();
		
		for(int i = 2; i >= 0; i--) {
			sbA.append(aList[i]);
			sbB.append(bList[i]);
		}
		
		int aNum = Integer.parseInt(sbA.toString());
		int bNum = Integer.parseInt(sbB.toString());
		
		if(aNum >= bNum) {
			System.out.println(aNum);
		}else {
			System.out.println(bNum);
		}
	}
}
