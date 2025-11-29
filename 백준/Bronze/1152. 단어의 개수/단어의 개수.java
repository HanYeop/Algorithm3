

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int result = 0;

		String[] strList = str.split(" ");
		
		for(int i = 0; i < strList.length; i++) {
			int curLen = strList[i].length();
			
			if(curLen == 0) {
				result--;
			}
		}

		System.out.println(strList.length + result);
	}
}
